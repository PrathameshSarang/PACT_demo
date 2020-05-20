package com.afourtech.controller.resources;

import com.codahale.metrics.health.HealthCheck;

public class EnvHealthCheck extends HealthCheck {

    private final String environment;

    public EnvHealthCheck(String environment) {
        this.environment=environment;
    }

    protected Result check() throws Exception {
            return Result.healthy();
    }
}
