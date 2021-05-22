package com.redhat.mercury.customeroffer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;


public final class CustomerOffer extends RouteBuilder {

    public void configure() {

        rest()
            .post("/customer-offer/activation")
                .id("activateSDCustomerOffer")
                .description("Activate a SDCustomerOffer servicing session")
                .produces("application/json")
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerOffer Request Payload")
                .endParam()
                .to("direct:activateSDCustomerOffer")
            .put("/customer-offer/{sdReferenceId}/configuration")
                .id("configureSDCustomerOffer")
                .description("Update an active SDCustomerOffer session configuration")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerOffer Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerOffer Configure Request Payload")
                .endParam()
                .to("direct:configureSDCustomerOffer")
            .put("/customer-offer/{sdReferenceId}/feedback")
                .id("feedbackSDCustomerOffer")
                .description("Capturing feedback against the SDCustomerOffer service that can target different levels of detail: SD/CR/BQ")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerOffer Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerOffer Feedback Request Payload")
                .endParam()
                .to("direct:feedbackSDCustomerOffer")
            .get("/customer-offer/{sdreferenceid}")
                .id("retrieveSDCustomerOffer")
                .description("Analytical views maintained by the SDCustomerOffer service center for management reporting and analysis purposes")
                .produces("application/json")
                .param()
                    .name("sdreferenceid")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerOffer Servicing Session Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/SDCustomerOfferRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveSDCustomerOffer");

        // This is scaffolding for you to own
        from("direct:activateSDCustomerOffer").to("log:activateSDCustomerOffer?level=INFO");
        from("direct:configureSDCustomerOffer").to("log:configureSDCustomerOffer?level=INFO");
        from("direct:feedbackSDCustomerOffer").to("log:feedbackSDCustomerOffer?level=INFO");
        from("direct:retrieveSDCustomerOffer").to("log:retrieveSDCustomerOffer?level=INFO");
               
    }
}
