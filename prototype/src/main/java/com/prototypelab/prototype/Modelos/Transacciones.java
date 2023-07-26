package com.prototypelab.prototype.Modelos;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transacciones {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "creation_date")
    private LocalTime horaCreacion = LocalTime.now();

    @Column(name = "amount", scale = 4)
    private double monto;

    @Column(name = "factor")
    private  double factor;

    @Column(name = "notes", length = 30)
    private String Description;

    @ManyToOne(targetEntity = Clientes.class)
    @JoinColumn(name = "client_id")
    private Clientes clientes;

    @ManyToOne(targetEntity = Provedores.class)
    @JoinColumn(name = "providers_id")
    private Provedores provedores;
}
