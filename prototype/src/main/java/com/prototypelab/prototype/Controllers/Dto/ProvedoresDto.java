package com.prototypelab.prototype.Controllers.Dto;

import com.prototypelab.prototype.Modelos.Documentos;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProvedoresDto {
    private String CodProv;
    private String Descrip;
    private String Direccion;
    private String Telef;
    private String Email;
    private String Key;

    private Date dateTimeFormat;
    private Date date;
    private List<Documentos> documentosDtoList;

}
