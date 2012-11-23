package com.mycompany.model;

import org.apache.camel.CamelContext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Contexts {

    @XmlElement(name = "context")
    private List<CamelContextWrapper> contexts = new ArrayList<CamelContextWrapper>();

    public Contexts() {
    }

    public void addContext(CamelContextWrapper context) {
        contexts.add(context);
    }

    public List<CamelContextWrapper> getContexts() {
        return contexts;
    }

    public void setContexts(List<CamelContextWrapper> contexts) {
        this.contexts = contexts;
    }

}