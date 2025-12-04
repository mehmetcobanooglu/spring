package com.mehmetcobanoglu.response;

public class ErrorMessage {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String prepareErrorMessage() {
        return "Error: " + message;
    }
}