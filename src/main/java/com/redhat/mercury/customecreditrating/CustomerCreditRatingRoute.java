package com.redhat.mercury.customecreditrating;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public final class CustomerCreditRatingRoute extends RouteBuilder {

    public void configure() {

        rest()
            .post("/customer-credit-rating/activation")
                .id("activateSDCustomerCreditRating")
                .description("Activate  a  SDCustomerCreditRating servicing session")
                .produces("application/json")
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerCreditRating Request Payload")
                .endParam()
                .to("direct:activateSDCustomerCreditRating")
            .put("/customer-credit-rating/{sdReferenceId}/configuration")
                .id("configureSDCustomerCreditRating")
                .description("Update an active SDCustomerCreditRating session configuration")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerCreditRating Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerCreditRating Configure Request Payload")
                .endParam()
                .to("direct:configureSDCustomerCreditRating")
            .put("/customer-credit-rating/{sdReferenceId}/feedback")
                .id("feedbackSDCustomerCreditRating")
                .description("Capturing feedback against the SDCustomerCreditRating service that can target different levels of detail: SD/CR/BQ")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerCreditRating Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDCustomerCreditRating Feedback Request Payload")
                .endParam()
                .to("direct:feedbackSDCustomerCreditRating")
            .get("/customer-credit-rating/{sdReferenceId}")
                .id("retrieveSDCustomerCreditRating")
                .description("Analytical views maintained by the SDCustomerCreditRating service center for management reporting and analysis purposes")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDCustomerCreditRating Servicing Session Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/SDCustomerCreditRatingRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveSDCustomerCreditRating");
    }
}
