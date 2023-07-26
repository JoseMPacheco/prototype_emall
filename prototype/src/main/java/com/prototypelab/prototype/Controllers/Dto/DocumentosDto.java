package com.prototypelab.prototype.Controllers.Dto;


import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentosDto {

    private String NumeroDoc;

    private float Factor;

    private float MontoGravable;

    private float MontoTotal;

    private float MontoTax;

    private boolean status;

    private String ProvedorId;

    private String ClienteId;


    private List<ItemsDocumentos> itemsDocumentosList;

}
