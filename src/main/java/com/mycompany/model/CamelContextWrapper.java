package com.mycompany.model;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CamelContext")
public class CamelContextWrapper {

    private String name;
    private String version;

    public CamelContextWrapper() {
    }

    public CamelContextWrapper(String name, String version) {
        this.name = name;
        this.version = version;
    }

    @Path("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Path("version")
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
