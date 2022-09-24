package com.example.identity.core.exception;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class ResponseError implements Serializable {
    private LocalDate timeStamp;
    private Map<String, Object> errors;

    public ResponseError() {
    }

    public ResponseError setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ResponseError setErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseError build() {
        return this;
    }
}
