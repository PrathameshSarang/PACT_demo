package com.sanity;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.afourtech.model.Employee;
import com.afourtech.model.EmployeeResp;
import com.remondis.cdc.consumer.pactbuilder.ConsumerBuilder;
import com.remondis.cdc.consumer.pactbuilder.ConsumerExpects;
import com.remondis.cdc.consumer.pactbuilder.PactDslModifier;
import java.util.HashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class Tests {


    private static PactDslModifier<Employee> employeeDataMapping() {
        return (pactDslJsonBody, fieldName, fieldValue) -> {
            return pactDslJsonBody.stringType(fieldName, fieldValue.toString());
        };
    }

    public DslPart pactBodyEmployeeLibrary() {
        EmployeeResp employeeResp = new EmployeeResp(new Employee(1,"Kings"));
/*

        DslPart employeeBody=ConsumerExpects.
            type(Employee.class)
            .useTypeMapping(Employee.class,(pactDslJsonBody, fieldName, fieldValue) -> {
                return pactDslJsonBody.stringType(fieldName, fieldValue.toString());
            })
            .build(new Employee(1,"Kings"));

        DslPart part=new PactDslJsonBody()
            .object("employee",employeeBody)
            .asBody();
*/
        PactDslJsonBody jsonBody = ConsumerExpects.type(EmployeeResp.class)
            .useTypeMapping(Employee.class,employeeDataMapping())
            .build(new PactDslJsonBody(), employeeResp);
        return jsonBody;
    }

    /*public PactDslJsonBody pactFromLibrary() {
        CategoryDataResponse categoryDataResponse=new CategoryDataResponse(new Status(), new CategoryDataDAO().getAllCategories());
        PactDslJsonBody jsonBody = ConsumerExpects.type(CategoryDataResponse.class)
                .referencing(categoryDefination())
                .referencing(statusDefination())
                .build(new PactDslJsonBody(), categoryDataResponse);
        return jsonBody;
    }*/

    public int mockPort=8111;

    @Rule
    public PactProviderRuleMk2 test_mockProvider=
        new PactProviderRuleMk2("test_provider","localhost",mockPort,this);

    @Pact(consumer = "test_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        HashMap<String,String> headers=new HashMap<>();
        headers.put("Content-Type", "application/json");


        DslPart currencyConversionRespBody=new Tests().pactBodyEmployeeLibrary();
        System.out.println(currencyConversionRespBody.toString());

        /*DslPart currencyConversionRespBody = new PactDslJsonBody()
            .integerType("id",10001)
            .stringType("from", "USD")
            .stringType("to", "INR")
            .integerType("conversionMultiple",65)
            .stringType("exchangeEnvironmentInfo"," ENV 1")
            .asBody();*/

        return builder.given("The value of 1 USD in INR is 65 INR")
            .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
            .path("/currency-exchange/from/USD/to/INR")
            .method("GET")
            .willRespondWith()
            .status(200)
            .headers(headers)
            .body(currencyConversionRespBody)
            .toPact();
    }

    @Test
    @PactVerification
    public void givenGet_currencyExchange_shouldReturn200_with_properBody(){

        Client client= ClientBuilder.newClient();
        WebTarget webTarget=client.target(test_mockProvider.getUrl() + "/currency-exchange/from/USD/to/INR");
        Response response=webTarget
            .request(MediaType.APPLICATION_JSON)
            .get();
        Assert.assertEquals(response.getStatus(),200);

        //Assert.assertEquals(response.getStatus(),200);

    }

}
