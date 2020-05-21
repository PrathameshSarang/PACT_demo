package com.afourtech.client;

import com.afourtech.api.CategoryDetails;
import com.afourtech.model.Status;

import javax.ws.rs.client.Client;

public class CategoryClient {

    private Client client;
    private String target ="http://localhost:8084";
    private String resource = "internal/listingreader/v1/category/";

    public void setTarget(String target) {
        this.target = target;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public CategoryClient(Client client) {
        this.client = client;
    }


    public CategoryDetails getCategoryById(String id){
            try {
                CategoryDetails res = this.client.target(target).path(resource+id).request().get(CategoryDetails.class);
                return res;
            }catch(Exception e)
            {
                e.printStackTrace();
                return  new CategoryDetails(new Status("Failed","Could not retrieve data from external service",500),null);
            }
    }
}
