package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextEnum {

    CREATE_ACCOUNT("CREATE AN ACCOUNT"),
    ACCOUNT_HAS_BEEN_CREATED("Your account has been created."),
    INFO_ACCOUNT_MESSAGE("Welcome to your account. Here you can manage all of your personal information and orders.");

    private final String text;
}
