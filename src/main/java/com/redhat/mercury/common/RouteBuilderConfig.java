package com.redhat.mercury.common;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class RouteBuilderConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        restConfiguration().bindingMode(RestBindingMode.json);
        
    }
    
}
