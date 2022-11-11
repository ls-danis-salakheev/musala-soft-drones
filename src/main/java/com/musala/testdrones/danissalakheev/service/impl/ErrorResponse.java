package com.musala.testdrones.danissalakheev.service.impl;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ErrorResponse {

    private Message message;

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
