package com.prototypelab.prototype.Controllers.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientesDto {
    private Long Id;
    private String CodigoCliente;
    private String Descripcion;
    private String IdentificadorCliente;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String CodProv;

}
