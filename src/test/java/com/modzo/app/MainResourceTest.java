package com.modzo.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainResourceTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void shouldLoadMainPage() {
        var result = testRestTemplate.getForEntity("/", MainResource.CustomResponse.class);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals("Welcome to main endpoint", result.getBody().getValue());
    }
}