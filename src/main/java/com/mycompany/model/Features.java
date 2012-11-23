package com.mycompany.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Features {

    @XmlElement(name = "feature")
    private List<FeatureWrapper> features = new ArrayList<FeatureWrapper>();

    public Features() {
    }

    public void addFeatures(FeatureWrapper feature) {
        features.add(feature);
    }

    public List<FeatureWrapper> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureWrapper> features) {
        this.features = features;
    }

}
