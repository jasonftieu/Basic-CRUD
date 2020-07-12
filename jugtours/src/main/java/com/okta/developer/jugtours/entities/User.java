package com.okta.developer.jugtours.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User
{
    @Id
    private String id;
    private String name;
    private String email;
}
