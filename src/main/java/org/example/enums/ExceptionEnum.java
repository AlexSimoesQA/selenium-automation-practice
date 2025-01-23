package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    INVALID_EMAIL_ADDRESS("Invalid email address.");

    private final String exception;
}
