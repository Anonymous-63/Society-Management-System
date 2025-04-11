package com.anonymous63.sms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
