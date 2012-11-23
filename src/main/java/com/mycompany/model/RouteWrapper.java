package com.mycompany.model;

import javax.ws.rs.Path;

public class RouteWrapper {

    private String name;
    private String version;

    public RouteWrapper() {
    }

    public RouteWrapper(String name, String version) {
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
