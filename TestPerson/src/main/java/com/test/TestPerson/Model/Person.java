package com.test.TestPerson.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "genfer", nullable = false)
    private Gender gender;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "num", nullable = false)
    private Integer num;

    @Column(name = "email", nullable = false)
    private String email;
}
