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


public class Test_ConsumerSide_v2 {

    public int mockPort=8085;

    @Rule
    public PactProviderRuleMk2 currencyExchange_mockProvider=
            new PactProviderRuleMk2("currencyExchange_provider","localhost",mockPort,this);

    @Pact(consumer = "currencyExchange_Consumer_v2")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        HashMap<String,String> headers=new HashMap<>();
        headers.put("Content-Type", "application/json");
        //From the consumer side we tell that we need the following things in the response
        DslPart currencyConversionRespBody_USD_to_INR = new PactDslJsonBody()
                .integerType("id",10001)
                .stringType("from", "USD")
                .stringType("to", "INR")
                .integerType("conversionMultiple",65)
                .stringType("exchangeEnvironmentInfo"," ENV 1")
                .asBody();

        DslPart currencyConversionRespBody_EUR_to_INR = new PactDslJsonBody()
                .integerType("id",10001)
                .stringType("from", "EUR")
                .stringType("to", "INR")
                .integerType("conversionMultiple",75)
                .stringType("exchangeEnvironmentInfo"," ENV 1")
                .asBody();

        DslPart currencyConversionRespBody_AUD_to_INR = new PactDslJsonBody()
                .integerType("id",10003)
                .stringType("from", "AUD")
                .stringType("to", "INR")
                .integerType("conversionMultiple",25)
                .stringType("exchangeEnvironmentInfo"," ENV 1")
                .asBody();

        return builder.given("The output of currency exchange service from 1 USD to 1 INR")
                .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
                .path("/currency-exchange/from/USD/to/INR")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(currencyConversionRespBody_USD_to_INR)
                .given("The output of currency exchange service from 1 EUR to 1 INR")
                .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
                .path("/currency-exchange/from/EUR/to/INR")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(currencyConversionRespBody_EUR_to_INR)
                .given("The output of currency exchange service from 1 AUD to 1 INR")
                .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
                .path("/currency-exchange/from/AUD/to/INR")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(currencyConversionRespBody_AUD_to_INR)
                .toPact();  // This creates a pact file
    }


    @Test
    @PactVerification
    public void runTest(){

        String from="USD";
        String to="INR";
        ListingReaderResponse listingReaderResponse;

        listingReaderResponse =ProxyApiController.retrieveExchangeValue(currencyExchange_mockProvider.getUrl(),from,to);
        Assert.assertEquals(listingReaderResponse.getConversionMultiple(),65);

        from="EUR";
        listingReaderResponse =ProxyApiController.retrieveExchangeValue(currencyExchange_mockProvider.getUrl(),from,to);
        Assert.assertEquals(listingReaderResponse.getConversionMultiple(),75);

        from="AUD";
        listingReaderResponse =ProxyApiController.retrieveExchangeValue(currencyExchange_mockProvider.getUrl(),from,to);
        Assert.assertEquals(listingReaderResponse.getConversionMultiple(),25);
    }

}
