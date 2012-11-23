package com.mycompany.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Routes {

    @XmlElement(name = "route")
    private List<RouteWrapper> routes = new ArrayList<RouteWrapper>();

    public Routes() {
    }

    public void addRoute(RouteWrapper route) {
        routes.add(route);
    }

    public List<RouteWrapper> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteWrapper> routes) {
        this.routes = routes;
    }

}
