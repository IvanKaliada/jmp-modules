package com.gmail.iikaliada.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Getter
@Setter
@Table(name = "users")
@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;

}
