package com.redhat.mercury.customecreditrating.state;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public final class InternalReporting extends RouteBuilder {

    public void configure() {

        rest()
            .put("/customer-credit-rating/{sdReferenceId}/customer-credit-rating-state/{crReferenceId}/internalreporting/{bqReferenceId}/capture")
                .id("captureCustomerCreditRatingStateInternalReportingUpdate")
                .description("Capture internal product reports to support credit analysis")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Credit Rating Servicing Session Reference")
                .endParam()
                .param()
                    .name("crReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Credit Rating State Instance Reference")
                .endParam()
                .param()
                    .name("bqReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("InternalReporting Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("InternalReporting request payload")
                .endParam()
                .to("direct:captureCustomerCreditRatingStateInternalReportingUpdate")
            .get("/customer-credit-rating/{sdReferenceId}/customer-credit-rating-state/{crReferenceId}/internalreporting/{bqReferenceId}/")
                .id("retrieveCustomerCreditRatingStateInternalReporting")
                .description("Retrieve details about internal reporting to the credit monitoring activity .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                    .name("sdReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Credit Rating Servicing Session Reference")
                .endParam()
                .param()
                    .name("crReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Customer Credit Rating State Instance Reference")
                .endParam()
                .param()
                    .name("bqReferenceId")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("InternalReporting Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/BQInternalReportingRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerCreditRatingStateInternalReporting");
    }
    
}