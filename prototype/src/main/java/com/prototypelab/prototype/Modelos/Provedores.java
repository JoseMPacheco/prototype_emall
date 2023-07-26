package com.prototypelab.prototype.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "providers")
public class Provedores {

    @Id
    @Column(name = "identifier_prov", length = 18, nullable = false )
    private String CodProv;

    @Column(name = "description_prov", length = 60, nullable = false, unique = true)
    private String Descrip;

    @Column(name = "address", length = 80, nullable = false)
    private String Direccion;

    @Column(name = "phone", length = 15, nullable = false, unique = true)
    private String Telef;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String Email;

    @Column(name = "key_app", length = 25, nullable = false)
    private String Key;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date FechaE;

    @Column(name = "changes_date")
    @Temporal(TemporalType.DATE)
    private Date FechaMod;

    @OneToMany(targetEntity = Clientes.class, fetch = FetchType.LAZY, mappedBy = "provedores")
    @JsonIgnore
    private List<Clientes> clientesList;

    @OneToMany(targetEntity = Documentos.class, fetch = FetchType.LAZY, mappedBy = "provedores")
    @JsonIgnore
    private List<Documentos> DocumentList;


    @OneToMany(targetEntity = Transacciones.class, fetch = FetchType.LAZY, mappedBy = "provedores")
    private List<Transacciones> TransaccionesList;




}
