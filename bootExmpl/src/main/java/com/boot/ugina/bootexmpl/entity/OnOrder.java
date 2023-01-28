package com.boot.ugina.bootexmpl.entity;

import com.boot.ugina.bootexmpl.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private boolean status;
    private OrderStatus currentStatus;
    private String orderUuid;
    @OneToMany(mappedBy = "ordered", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Item> itemCollection = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Customer owner;
}
