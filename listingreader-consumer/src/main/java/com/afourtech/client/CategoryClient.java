package com.afourtech.client;

import com.afourtech.api.CategoryDataResponse;
import com.afourtech.model.Status;

import javax.ws.rs.client.Client;

public class CategoryClient {

    private Client client;
    private final String target ="http://localhost:8084";
    private String resource = "internal/listingreader/v1/category/";

    public CategoryClient(Client client) {
        this.client = client;
    }

    public CategoryDataResponse getCategoryById(String id){
            try {
                CategoryDataResponse res = this.client.target(target).path(resource+id).request().get(CategoryDataResponse.class);
                return res;
            }catch(Exception e)
            {
                e.printStackTrace();
                return  new CategoryDataResponse(new Status("Failed","Could not retrieve data from external service",500),null);
            }
    }
}
