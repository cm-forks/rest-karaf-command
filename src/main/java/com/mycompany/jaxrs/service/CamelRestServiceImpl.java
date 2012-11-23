package com.mycompany.jaxrs.service;

import com.mycompany.model.CamelContextWrapper;
import com.mycompany.model.Contexts;
import com.mycompany.model.RouteWrapper;
import com.mycompany.model.Routes;
import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.RoutesDefinition;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class CamelRestServiceImpl implements CamelRestService {

    private static final transient Logger LOG = LoggerFactory.getLogger(CamelRestServiceImpl.class);
    private static List<CamelContext> camelContexts = new ArrayList<CamelContext>();

    private BundleContext bundleContext;

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public Contexts getContexts() throws Exception {
        Contexts contexts = new Contexts();
        try {
            ServiceReference[] references = bundleContext.getServiceReferences(CamelContext.class.getName(), null);
            if (references != null) {
                for (ServiceReference reference : references) {
                    if (reference != null) {
                        CamelContext camelContext = (CamelContext) bundleContext.getService(reference);
                        if (camelContext != null) {
                            CamelContextWrapper wrapper = new CamelContextWrapper(camelContext.getName(), camelContext.getVersion());
                            contexts.addContext(wrapper);
                            camelContexts.add(camelContext);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.warn("Cannot retrieve the list of Camel contexts.", e);
        }
        return contexts;
    }

    public Routes getRoutes() throws Exception {
        List<Route> routesReceived = new ArrayList<Route>();
        Routes routes = new Routes();
        for(CamelContext ctx : camelContexts) {
            routesReceived = ctx.getRoutes();
            for(Route route : routesReceived) {
                RouteWrapper wrapper= new RouteWrapper(route.getId(),route.getId());
                routes.addRoute(wrapper);
           }
        }
        return routes;

    }


}
