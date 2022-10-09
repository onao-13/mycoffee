package com.example.mycoffee.mapping.requests;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    @NotNull
    private String number;

    @NotNull
    private String name;

    @NotNull
    private String password;
}
