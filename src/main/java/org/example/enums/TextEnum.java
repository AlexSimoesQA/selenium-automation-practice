package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextEnum {

    CREATE_ACCOUNT("CREATE AN ACCOUNT");

    private final String text;
}
