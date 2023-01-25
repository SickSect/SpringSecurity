package com.boot.ugina.bootexmpl.entity;

import com.boot.ugina.bootexmpl.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private boolean status;
    private OrderStatus currentStatus;
    private String orderUuid;
    @OneToMany(mappedBy = "ordered", fetch = FetchType.EAGER)
    private Collection<Item> itemCollection;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer owner;
}
