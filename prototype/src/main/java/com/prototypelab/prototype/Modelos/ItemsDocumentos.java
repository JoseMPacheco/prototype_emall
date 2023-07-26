package com.prototypelab.prototype.Modelos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents_items")
public class ItemsDocumentos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "product_code", length = 15, nullable = false)
    private String CodProd;

    @Column(name = "description_item", length = 40, nullable = false)
    private String Descripcion;

    @Column(name  = "description_item2", length = 40)
    private  String Descripcion2;

    @Column(name = "nro_linea", nullable = false)
    private int NroLinea;

    @Column(name = "precio_ref", scale = 4)
    private double precioRef;

    @Column(name = "precio", scale = 4, nullable = false)
    private double precioBs;

    @Column(name = "quantity_item", nullable = false)
    private int cantidad;

    @ManyToOne(targetEntity = Documentos.class)
    @JoinColumn(name = "num_doc")
    @JsonIgnore
    private Documentos documentos;


}
