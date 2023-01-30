package com.boot.ugina.bootexmpl.entity;

import com.boot.ugina.bootexmpl.entity.enums.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private String customerUuid;
    private Roles role;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonBackReference
    private List<OnOrder> orderList;
}
