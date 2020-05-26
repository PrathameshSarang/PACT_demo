package com.sanity;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.afourtech.api.CategoryDetails;
import com.afourtech.model.CategoryData;
import com.afourtech.model.Status;
import com.afourtech.model.dao.CategoryDataDAO;
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

public class ListingReader_ConsumerSideV3 {




  public PactDslJsonBody pactFromLibrary(String categoryId) {
    CategoryDetails categoryDataResponse = new CategoryDetails(new Status("ok","OK",200),
        new CategoryDataDAO().getSpecificCategory(categoryId));

    ConsumerBuilder<CategoryDetails> anotherConsumer = null;
    ConsumerBuilder<Status> status = null;
    ConsumerBuilder<CategoryData> data = null;
    PactDslJsonBody pactDslJsonBody1 = null;

    status=ConsumerExpects.type(Status.class)
        .field(Status::getStatus)
        .as(pact -> pact.stringType("status","ok"))
        .field(Status::getMessage)
        .as(pact -> pact.stringType("message","OK"))
        .field(Status::getCode)
        .as(pact ->pact.integerType("code",200));

    data=ConsumerExpects.type(CategoryData.class)
        .field(CategoryData::getId)
        .as(pact -> pact.stringType("id","5"));
        /*.field(CategoryData::getChildren)
        .as()*/
    PactDslJsonBody pactDslJsonBody = ConsumerExpects.type(CategoryDetails.class)
        .field(CategoryDetails::getStatus)
        .as(status)
        .field(CategoryDetails::getData)
        .as(data)
        .build(categoryDataResponse);
    return pactDslJsonBody;
  }

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

    /*DataUtility dataUtility = new DataUtility();
    String responseBody1 = dataUtility.getJsonRequestBody("prodyuctListingByOwner1.json")
        .toString();
    String responseBody2 = dataUtility.getJsonRequestBody("prodyuctListingByOwner2.json")
        .toString();*/
    ListingReader_ConsumerSideV3 object=new ListingReader_ConsumerSideV3();
    PactDslJsonBody pactDslJsonBody1=object.pactFromLibrary("5");
    PactDslJsonBody pactDslJsonBody2=object.pactFromLibrary("6");

    System.err.println(pactDslJsonBody1);
    return builder.given("The value of ListingReader API catagory 5")
        .uponReceiving("GET REQUEST /internal/listingreader/v1/category/5")
        .path("/internal/listingreader/v1/category/5")
        .method("GET")
        .willRespondWith()
        .status(200)
        .headers(headers)
        .body(pactDslJsonBody1)
        .given("The value of ListingReader API catagory 6")
        .uponReceiving("GET REQUEST /internal/listingreader/v1/category/6")
        .path("/internal/listingreader/v1/category/6")
        .method("GET")
        .willRespondWith()
        .status(200)
        .headers(headers)
        .body(pactDslJsonBody2)
        .toPact();  // This creates a pact file
  }

  /**
   * Description : The Consumer(Order Service) Verification by calling the Mock Producer(Category
   * Service) Service And Generates the Pact File
   */
/*  @Test
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

  }*/

  @Test
  @PactVerification
  public void test_givenOrderIdShouldGetOrderDetails() {
    Client client= ClientBuilder.newClient();
    WebTarget webTarget1=client.target(listingReader_provider.getUrl() + "/internal/listingreader/v1/category/5");
    Response response1=webTarget1
        .request(MediaType.APPLICATION_JSON)
        .get();
    Assert.assertEquals(response1.getStatus(),200);
    webTarget1=client.target(listingReader_provider.getUrl() + "/internal/listingreader/v1/category/6");
    response1=webTarget1
        .request(MediaType.APPLICATION_JSON)
        .get();
  }
}
