package com.redhat.mercury.customeroffer.procedure;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public final class Product extends RouteBuilder {

    public void configure() {

        rest()
            .put("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/product/{bqReferenceId}/update")
                .id("updateCustomerOfferProcedureProduct")
                .description("Update product options and pricing terms")
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
                    .description("Product Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Request Payload")
                .endParam()
                .to("direct:updateCustomerOfferProcedureProduct")
            .put("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/product/{bqReferenceId}/exchange")
                .id("exchangeCustomerOfferProcedureProductUpdate")
                .description("Accept, reject etc product options and pricing terms")
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
                    .description("Product Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product request payload")
                .endParam()
                .to("direct:exchangeCustomerOfferProcedureProductUpdate")
            .get("/customer-offer/{sdReferenceId}/customer-offer-procedure/{crReferenceId}/product/{bqReferenceId}/")
                .id("retrieveCustomerOfferProcedureProduct")
                .description("Retrieve details about product options and pricing terms .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
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
                    .description("Product Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/BQProductRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerOfferProcedureProduct");

        from("direct:updateCustomerOfferProcedureProduct").to("log:updateCustomerOfferProcedureProduct?level=INFO");
        from("direct:exchangeCustomerOfferProcedureProductUpdate")
                .to("log:exchangeCustomerOfferProcedureProductUpdate?level=INFO");
        from("direct:retrieveCustomerOfferProcedureProduct").to("log:retrieveCustomerOfferProcedureProduct?level=INFO");
    }
}