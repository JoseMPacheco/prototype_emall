package com.prototypelab.prototype.Modelos;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_type")
public class TipoClientes {

    @Id
    @Column(name = "client_type_id", nullable = false, length = 8)
    private String CodClientType;

    @Column(name = "descrip", length = 35, nullable = false)
    private String Descripcion;

    @Column(name = "customer_relations", length = 40, nullable = false)
    private String Table;

    @OneToMany(targetEntity = Clientes.class, fetch = FetchType.LAZY, mappedBy = "tipoClientes")
    private List<Clientes> clientesList;
}
