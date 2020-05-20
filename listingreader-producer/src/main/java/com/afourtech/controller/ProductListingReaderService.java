package com.afourtech.controller;

import com.afourtech.beans.CategoryDataResponse;

import com.afourtech.beans.ListingReaderResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Path("/internal/listingreader/v1")
@Produces(MediaType.APPLICATION_JSON)
public class ProductListingReaderService {


    private final int port=8010;
    private final String protocol="http";
    private final String host="localhost";

    @GET
    @Path("/listing/{listingId}")
    public ListingReaderResponse getCategoryById(@PathParam("listingId") String categoryId) {

        //TODO: Retrieve data from dummy DAO and populated ListingReaderResponse or just return the same value always
        // i.e.   return new ProductListing in the ListingReaderResponse();


        throw new NotImplementedException();
    }

    @GET
    @Path("/listings")
    public ListingReaderResponse getAllCategories() {

        //TODO: Retrieve data from dummy DAO and populated ListingReaderResponse or just return the same value always
        // i.e.   return new array of  ProductListing in the ListingReaderResponse data section;
        throw new NotImplementedException();
    }
}
