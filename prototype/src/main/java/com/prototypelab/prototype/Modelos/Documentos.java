package com.prototypelab.prototype.Modelos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Documentos {

    @Id
    @Column(name = "num_doc", length = 12, nullable = false)
    private String NumeroDoc;

    @Column(name = "factor", scale = 2,   nullable = false )
    private float Factor;

    @Column(name = "taxable_amount", scale = 2,   nullable = false )
    private float MontoGravable;

    @Column(name = "total_amount", scale = 2,   nullable = false )
    private float MontoTotal;

    @Column(name = "tax_amount", scale = 2,   nullable = false , columnDefinition = "DECIMAL(18,4)")
    private float MontoTax;

    @Column(name = "status", columnDefinition = "INT(1)",  nullable = false)
    private boolean status;

    @Column(name = "creation_date")
    private LocalTime horaCreacion;

    @ManyToOne(targetEntity = Clientes.class)
    @JoinColumn(name = "client_id")
    private Clientes clientes;

    @ManyToOne(targetEntity = Provedores.class)
    @JoinColumn(name = "providers_id")
    private Provedores provedores;

    @OneToMany(targetEntity = ItemsDocumentos.class, fetch = FetchType.EAGER, mappedBy = "documentos")
    @JsonIgnore
    private List<ItemsDocumentos> itemsDocumentosList;




}
