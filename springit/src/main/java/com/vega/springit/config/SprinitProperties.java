package com.vega.springit.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springit")
public class SprinitProperties {
    /**
     * This is welcome message
     *
     */

    private String welcomeMG = " This is welcome message Test";

    public String getWelcomeMG() {
        return welcomeMG;
    }

    public void setWelcomeMG(String welcomeMG) {
        this.welcomeMG = welcomeMG;
    }
}
