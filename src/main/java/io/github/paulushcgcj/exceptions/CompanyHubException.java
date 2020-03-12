package io.github.paulushcgcj.exceptions;

import lombok.Getter;

public class CompanyHubException extends Exception {
    @Getter
    private int statusCode = 500;

    public CompanyHubException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
