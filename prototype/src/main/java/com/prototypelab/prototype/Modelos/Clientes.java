package com.prototypelab.prototype.Modelos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Clientes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long Id;

    @Column(name = "description", length = 40, nullable = false)
    private String Descripcion;

    @Id
    @Column(name = "identifier", length = 15,nullable = false, unique = true)
    private String IdentificadorCliente;

    @Column(name = "address", length = 50, nullable = false)
    private String Direccion;

    @Column(name = "phone", length = 12, nullable = false)
    private String Telefono;

    @Column(name = "email", length = 40, nullable = false)
    private String Email;

    @Column(name = "email_alternated", length = 40, nullable = false)
    private String EmailSecun;

    @Column(name = "creation_date", length = 40, nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaE;

    @Column(name = "changes_date", length = 40, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaMod;


    @ManyToOne(targetEntity = Provedores.class)
    @JoinColumn(name = "providers_id")
    @JsonIgnore
    private Provedores provedores;

    @ManyToOne(targetEntity = TipoClientes.class)
    @JoinColumn(name = "customer_type")
    @JsonIgnore
    private TipoClientes tipoClientes;

    @OneToMany(targetEntity = Documentos.class, fetch = FetchType.LAZY, mappedBy = "clientes")
    @JsonIgnore
    private List<Documentos> DocumentList;

    @OneToMany(targetEntity = Transacciones.class, fetch = FetchType.LAZY, mappedBy = "clientes")
    @JsonIgnore
    private List<Transacciones> TransaccionesList;


}
