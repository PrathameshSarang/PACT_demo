package com.afourtech;

import com.afourtech.client.CategoryClient;
import com.afourtech.controller.OrdersController;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;


public class ConsumerApplication extends Application<ApplicationConfiguration> {

    private static final Logger LOGGER= LoggerFactory.getLogger(ConsumerApplication.class);
    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering Rest Service");
        JerseyClientConfiguration conf = configuration.getJerseyClientConfiguration();
        final Client client = new JerseyClientBuilder(environment).using(conf).build(getName());
//        environment.jersey().register(new CategoryClient(client));
        environment.jersey().register(new OrdersController(environment.getValidator(),new CategoryClient(client)));
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        //super.initialize(bootstrap);
    }

    public static void main(String[] args) throws Exception {
        new ConsumerApplication().run(args);
    }
}

