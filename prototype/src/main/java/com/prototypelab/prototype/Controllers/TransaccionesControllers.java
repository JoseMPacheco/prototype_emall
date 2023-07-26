package com.prototypelab.prototype.Controllers;


import com.prototypelab.prototype.Controllers.Dto.TipoClientesDto;
import com.prototypelab.prototype.Controllers.Dto.TransaccionesDto;
import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Modelos.Transacciones;
import com.prototypelab.prototype.Services.iTransaccionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/transactions")
public class TransaccionesControllers {



    @Autowired
    iTransaccionesServices iTransaccionesServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindById(@PathVariable Long id){
        Optional<Transacciones> optional = iTransaccionesServices.FindById(id);

        if(optional.isPresent()){
            Transacciones transacciones = optional.get();
            TransaccionesDto transaccionesDto = TransaccionesDto.builder()
                    .Id(transacciones.getId())
                    .monto(transacciones.getMonto())
                    .factor(transacciones.getFactor())
                    .horaCreacion(transacciones.getHoraCreacion())
                    .build();


            return ResponseEntity.ok(transaccionesDto);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<TransaccionesDto> transaccionesDtos = iTransaccionesServices.FindAll()
                .stream()
                .map(transacciones -> TransaccionesDto.builder()
                        .Id(transacciones.getId())
                        .monto(transacciones.getMonto())
                        .factor(transacciones.getFactor())
                        .Description(transacciones.getDescription())
                        .horaCreacion(transacciones.getHoraCreacion())
                        .build())
                .toList();
        return ResponseEntity.ok(transaccionesDtos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TransaccionesDto transacciones) throws URISyntaxException {
        if(transacciones.getDescription().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        iTransaccionesServices.save(Transacciones.builder()
                .Description(transacciones.getDescription())
                .build());

        return ResponseEntity.created(new URI("api/transactions/save")).build();

    }
}

