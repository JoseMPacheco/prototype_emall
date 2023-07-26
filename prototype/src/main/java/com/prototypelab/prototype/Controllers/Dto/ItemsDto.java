package com.prototypelab.prototype.Controllers.Dto;


import com.prototypelab.prototype.Modelos.Documentos;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemsDto {

    private Long Id;

    private String CodProd;

    private String Descripcion;

    private  String Descripcion2;

    private int NroLinea;

    private double precioRef;

    private double precioBs;

    private int cantidad;

    private String NumeroDoc;
}
