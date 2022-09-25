package com.pragma.pragma.models;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String password;

    public UserDb() {

    }
}
