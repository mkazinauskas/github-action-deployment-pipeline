package com.modzo.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MainResource {

    @GetMapping("/")
    ResponseEntity<CustomResponse> main() {
        return ResponseEntity.ok(new CustomResponse("Welcome to main endpoint"));
    }

    public static class CustomResponse {

        private final String value;

        @JsonCreator
        public CustomResponse(@JsonProperty(value = "value") String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
