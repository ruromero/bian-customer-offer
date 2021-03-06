package com.redhat.mercury.customeroffer.procedure;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public final class Underwriting extends RouteBuilder {

    public void configure() {

        rest()
           .put("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/underwriting/{bqReferenceId}/update")
                .id("updateCustomerOfferProcedureUnderwriting")
                .description("Update submitted materials for the underwriting decision")
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
                    .name("bqReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Underwriting Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Underwriting Request Payload")
                .endParam()
                .to("direct:updateCustomerOfferProcedureUnderwriting")
            .get("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/underwriting/{bqReferenceId}/")
                .id("retrieveCustomerOfferProcedureUnderwriting")
                .description("Retrieve details about the underwriting decision .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
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
                    .name("bqReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Underwriting Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/BQUnderwritingRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerOfferProcedureUnderwriting");
        
        from("direct:updateCustomerOfferProcedureUnderwriting")
                .to("log:updateCustomerOfferProcedureUnderwriting?level=INFO");
        from("direct:retrieveCustomerOfferProcedureUnderwriting")
                .to("log:retrieveCustomerOfferProcedureUnderwriting?level=INFO");
    }
}
