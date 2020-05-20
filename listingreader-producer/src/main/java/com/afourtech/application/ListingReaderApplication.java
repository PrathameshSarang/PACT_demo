package com.afourtech.application;

import com.afourtech.configuration.EnvironmentConfiguration;
import com.afourtech.controller.CategoryService;
import com.afourtech.controller.ProductListingReaderService;
import com.afourtech.controller.resources.EnvHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListingReaderApplication extends Application<EnvironmentConfiguration> {

    private static final Logger LOGGER= LoggerFactory.getLogger(ListingReaderApplication.class);
    @Override
    public void run(EnvironmentConfiguration environmentConfiguration, Environment environment) throws Exception {
        final ProductListingReaderService productListingReaderService=new ProductListingReaderService();
        final CategoryService categoryService = new CategoryService();
        EnvHealthCheck envHealthCheck=new EnvHealthCheck(environmentConfiguration.getEnvName());
        environment.healthChecks().register("envCheck-Application2",envHealthCheck);
        environment.jersey().register(productListingReaderService);
        environment.jersey().register(categoryService);
    }

    public static void main(String[] args) {
        try {
            new ListingReaderApplication().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
