package com.sanity;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.afourtech.api.OrderDetails;
import com.afourtech.client.CategoryClient;
import com.afourtech.controller.OrderService;
import com.afourtech.model.Order;
import com.afourtech.model.OrderStatus;
import com.afourtech.utility.DataUtility;
import org.codehaus.groovy.ast.GenericsType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.HashMap;

public class ListingReader_ConsumerSide {

  public int mockPort = 8111;

  /**
   * @Description Creates a mock provider by the given name : listingReader_provider And the mock
   * service will be hosted in URL >http://localhost:8111
   */
  @Rule
  public PactProviderRuleMk2 listingReader_provider =
      new PactProviderRuleMk2("listingReader_provider", "localhost", mockPort, this);

  /**
   * @Description : Specifies the desired Interactions between the Producer and Consumer
   */
  @Pact(consumer = "listingReader_Consumer")
  public RequestResponsePact createPact(PactDslWithProvider builder) {

    HashMap<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");

    DataUtility dataUtility = new DataUtility();
    String responseBody1 = dataUtility.getJsonRequestBody("prodyuctListingByOwner1.json")
        .toString();
    String responseBody2 = dataUtility.getJsonRequestBody("prodyuctListingByOwner2.json")
        .toString();

    return builder.given("The value of ListingReader API catagory 5")
        .uponReceiving("GET REQUEST /internal/listingreader/v1/category/5")
        .path("/internal/listingreader/v1/category/5")
        .method("GET")
        .willRespondWith()
        .status(200)
        .headers(headers)
        .body(responseBody1)
        .given("The value of ListingReader API catagory 6")
        .uponReceiving("GET REQUEST /internal/listingreader/v1/category/6")
        .path("/internal/listingreader/v1/category/6")
        .method("GET")
        .willRespondWith()
        .status(200)
        .headers(headers)
        .body(responseBody2)
        .toPact();  // This creates a pact file
  }

  /**
   * Description : The Consumer(Order Service) Verification by calling the Mock Producer(Category
   * Service) Service And Generates the Pact File
   */
  @Test
  @PactVerification
  public void test_givenOrderIdShouldGetOrderDetails() {

    Client client = ClientBuilder.newClient();
    CategoryClient categoryClient = new CategoryClient(client);
    categoryClient.setTarget(listingReader_provider.getUrl());
    categoryClient.setResource("/internal/listingreader/v1/category/");

    //Consumer(Order service) is taking the instance of Producer(Category Service)
    OrderService orderService = new OrderService(categoryClient);

    Order order_1 = new Order(
        1,
        10,
        "5",
        100,
        200,
        OrderStatus.FULFILLED
    );

    // Internally the Consumer(Order service) calling the Producer(Category Service)
    OrderDetails orderDetails_1 = orderService.getOrderById(order_1.getOrderId());

    // Verifying the Desired Output is returned or not
    Assert.assertEquals(order_1.toString(), orderDetails_1.getOrder().toString());
    Assert.assertEquals("Vehicles", orderDetails_1.getCategory().getLabel());

    int orderId_2 = 2;
    OrderDetails orderResponse_2 = orderService.getOrderById(orderId_2);

  }
}
