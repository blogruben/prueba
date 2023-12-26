package com.prueba.api.client;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractClient {

    @Value("${worldcup.base-url}")
    protected String baseUrl;

}
