package com.tests;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.afourtech.beans.ListingReaderResponse;
import com.afourtech.controller.ProxyApiController;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;

/**
 * @description Junit Rule of writing the PACT Test File
 */
public class Test_ConsumerSide_v1 {

    public int mockPort=8085;

    @Rule
    public PactProviderRuleMk2 currencyExchange_mockProvider=
            new PactProviderRuleMk2("currencyExchange_provider","localhost",mockPort,this);


    @Pact(consumer = "currencyExchange_Consumer_v1")
    public RequestResponsePact createPact1(PactDslWithProvider builder){

        HashMap<String,String> headers=new HashMap<>();
        headers.put("Content-Type", "application/json");
        //From the consumer side we tell that we need the following things in the response
        DslPart currencyConversionRespBody = new PactDslJsonBody()
                .integerType("id",10001)
                .stringType("from", "USD")
                .stringType("to", "INR")
                .integerType("conversionMultiple",65)
                .stringType("exchangeEnvironmentInfo"," ENV 1")
                .asBody();

        return builder.given("Producer Test for 1 USD to 1 INR conversion")
                .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
                .path("/currency-exchange/from/USD/to/INR")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(currencyConversionRespBody)
                .toPact();  // This creates a pact file
    }

    @Test
    @PactVerification
    public void test1(){

        String from="USD";
        String to="INR";
        ListingReaderResponse listingReaderResponse =ProxyApiController.retrieveExchangeValue(currencyExchange_mockProvider.getUrl(),from,to);

        Assert.assertEquals(listingReaderResponse.getConversionMultiple(),65);
    }

}
