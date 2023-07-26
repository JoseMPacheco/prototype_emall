package com.prototypelab.prototype.Controllers;


import com.prototypelab.prototype.Controllers.Dto.ProvedoresDto;
import com.prototypelab.prototype.Controllers.Dto.TipoClientesDto;
import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Services.ITipoClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/type")
public class TipoClientesControllers {


    @Autowired
    ITipoClientesServices tipoClientesServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindById(@PathVariable String id){
        Optional<TipoClientes> optional = tipoClientesServices.FindCustomerTypeById(id);

        if(optional.isPresent()){
            TipoClientes tipoClientes = optional.get();
            TipoClientesDto tipoClientesDto = TipoClientesDto.builder()
                    .CodClientType(tipoClientes.getCodClientType())
                    .Descripcion(tipoClientes.getDescripcion())
                    .Table(tipoClientes.getTable())
                    .build();


            return ResponseEntity.ok(tipoClientesDto);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<TipoClientesDto> tipoClientesDtos = tipoClientesServices.FindAll()
                .stream()
                .map(tipoClientes -> TipoClientesDto.builder()
                        .CodClientType(tipoClientes.getCodClientType())
                        .Descripcion(tipoClientes.getDescripcion())
                        .Table(tipoClientes.getTable())
                        .build())
                .toList();
        return ResponseEntity.ok(tipoClientesDtos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TipoClientesDto tiposClientes) throws URISyntaxException {
        if(tiposClientes.getDescripcion().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        tipoClientesServices.save(TipoClientes.builder()
                .Descripcion(tiposClientes.getDescripcion())
                .build());

        return ResponseEntity.created(new URI("api/type/save")).build();

    }
}
