package com.prototypelab.prototype.Controllers.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransaccionesDto {
    private Long Id;
    private LocalTime horaCreacion = LocalTime.now();
    private double monto;
    private String Description;
    private  double factor;

}
