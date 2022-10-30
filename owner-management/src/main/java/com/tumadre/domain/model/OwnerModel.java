package com.tumadre.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerModel {

    private String firstname;
    private String lastname;
    private String dpi;
    private LocalDateTime birthdate;
    private String address;
    private String email;
    private String phone;
}
