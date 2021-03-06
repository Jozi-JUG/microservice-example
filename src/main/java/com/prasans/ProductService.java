package com.prasans;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ProductService extends Service<ProductConfiguration> {
    @Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
        bootstrap.setName("product-list");
    }

    @Override
    public void run(ProductConfiguration productConfiguration, Environment environment) throws Exception {
        environment.addResource(new ProductResource());
        environment.addHealthCheck(new ProductHealthCheck("product"));
    }

    public static void main(String[] args) throws Exception {
        new ProductService().run(args);
    }
}
