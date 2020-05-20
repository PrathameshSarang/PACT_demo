package com.afourtech.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class EnvironmentConfiguration extends Configuration {

    @NotEmpty
    private String envName="STAGE";

    @JsonProperty
    public String getEnvName() {
        return envName;
    }

    @JsonProperty
    public void setEnvName(String envName) {
        this.envName = envName;
    }
}
