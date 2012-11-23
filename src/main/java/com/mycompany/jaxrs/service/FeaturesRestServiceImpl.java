package com.mycompany.jaxrs.service;

import com.mycompany.model.FeatureWrapper;
import com.mycompany.model.Features;
import org.apache.karaf.features.Feature;
import org.apache.karaf.features.FeaturesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the Features REST service.
 */
@Path("/")
public class FeaturesRestServiceImpl implements FeaturesRestService {

    private FeaturesService featuresService;

    public FeaturesService getFeaturesService() {
        return this.featuresService;
    }

    public void setFeaturesService(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    public Features getFeatures() throws Exception {
        //List featuresWrapper = new ArrayList();
        Features features = new Features();
        Feature[] featuresRetrieved = featuresService.listFeatures();
        for (int i = 0; i < featuresRetrieved.length; i++) {
            FeatureWrapper wrapper = new FeatureWrapper(featuresRetrieved[i].getName(), featuresRetrieved[i].getVersion());
            //featuresWrapper.add(wrapper);
            features.addFeatures(wrapper);
        }
        //return featuresWrapper;
        return features;

    }
}