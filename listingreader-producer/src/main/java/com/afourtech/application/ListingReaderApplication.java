package com.afourtech.application;

import com.afourtech.configuration.EnvironmentConfiguration;
import com.afourtech.controller.CategoryService;
import com.afourtech.controller.CategoryServiceV2;
import com.afourtech.controller.CategoryServiceV3;
import com.afourtech.controller.ProductListingReaderService;
import com.afourtech.controller.resources.EnvHealthCheck;
//import com.afourtech.trace.TraceMonitor;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import javassist.bytecode.stackmap.BasicBlock.Catch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListingReaderApplication extends Application<EnvironmentConfiguration> {

    private static final Logger LOGGER= LoggerFactory.getLogger(ListingReaderApplication.class);
    @Override
    public void run(EnvironmentConfiguration environmentConfiguration, Environment environment) throws Exception {
        //TraceMonitor traceMonitor=new TraceMonitor();
        final ProductListingReaderService productListingReaderService=new ProductListingReaderService();
        //final CategoryService categoryService = new CategoryService();

        EnvHealthCheck envHealthCheck=new EnvHealthCheck(environmentConfiguration.getEnvName());
        environment.healthChecks().register("envCheck-Application2",envHealthCheck);
        environment.jersey().register(productListingReaderService);
        //environment.jersey().register(traceMonitor);
        //final CategoryService categoryService = new CategoryService(traceMonitor);
        final CategoryService categoryService = new CategoryService();
        environment.jersey().register(categoryService);
        environment.jersey().register(new CategoryServiceV2());
        environment.jersey().register(new CategoryServiceV3());
        //
    }

    public static void main(String[] args) {
        try {
            new ListingReaderApplication().run(args);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
