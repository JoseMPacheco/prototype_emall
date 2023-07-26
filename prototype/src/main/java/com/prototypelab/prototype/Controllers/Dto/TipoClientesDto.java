package com.prototypelab.prototype.Controllers.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoClientesDto {
    private String CodClientType;
    private String Descripcion;
    private String Table;
}
