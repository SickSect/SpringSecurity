package com.boot.ugina.bootexmpl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public enum Role{
    USER,
    ADMIN
}
