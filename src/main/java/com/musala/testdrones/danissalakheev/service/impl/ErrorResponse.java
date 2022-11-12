package com.musala.testdrones.danissalakheev.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    private final Message message;

    @Data
    public static class Message {
        private List<Violation> violationList = new ArrayList<>();
    }

    @Data
    @Accessors(chain = true)
    public static class Violation {
        private String fieldName;
        private String message;
    }

}
