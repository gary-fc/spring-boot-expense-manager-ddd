package com.garyfrancodev.ExpenseManagerInfrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "transfers")
public class TransferJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    private AccountJpaModel accountSend;

    @ManyToOne
    private AccountJpaModel accountReceives;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private UserJpaModel user;
}
