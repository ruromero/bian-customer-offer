package com.redhat.mercury.customeroffer.procedure;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public final class BehaviorQualifier extends RouteBuilder {

    public void configure() {

        rest()
           .get("/customer-offer/customer-offer-procedure/behavior-qualifiers/")
                .id("RetrieveCustomerOfferBehaviorQualifiers")
                .produces("application/json")
                .to("direct:RetrieveCustomerOfferBehaviorQualifiers")
            .get("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/{behaviorQualifier}/")
                .id("RetrieveCustomerOfferBehaviorQualifierReferenceIds")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Offer Servicing Session Reference")
                .endParam()
                .param()
                    .name("crReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Offer Procedure Instance Reference")
                .endParam()
                .param()
                    .name("behaviorQualifier")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Behavior Qualifier Name. ex- ProductInitialization")
                .endParam()
                .param()
                    .name("collection-filter")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Filter to refine the result set. ex- ProductInitialization Instance Status = 'pending'")
                .endParam()
                .to("direct:RetrieveCustomerOfferBehaviorQualifierReferenceIds");

        // This is scaffolding for you to own    
        from("direct:RetrieveCustomerOfferBehaviorQualifiers")
                .to("log:RetrieveCustomerOfferBehaviorQualifiers?level=INFO");
        from("direct:RetrieveCustomerOfferBehaviorQualifierReferenceIds")
                .to("log:RetrieveCustomerOfferBehaviorQualifierReferenceIds?level=INFO");  
    }
}
