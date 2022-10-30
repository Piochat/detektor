package com.tumadre.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Owners")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String dpi;
    private LocalDateTime birthdate;
    private String address;
    @Column(unique = true)
    private String email;
    private String phone;
    private Boolean erased;
}
