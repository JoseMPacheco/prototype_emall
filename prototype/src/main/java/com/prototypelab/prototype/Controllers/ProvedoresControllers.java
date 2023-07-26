package com.prototypelab.prototype.Controllers;

import com.prototypelab.prototype.Controllers.Dto.ProvedoresDto;
import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Services.iProvedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/providers")
public class ProvedoresControllers {


    @Autowired
    iProvedoresServices provedoresServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindById(@PathVariable String id){
        Optional<Provedores> optional = provedoresServices.FindClientesByid(id);

        if(optional.isPresent()){
            Provedores provedores = optional.get();
            ProvedoresDto provedoresDto = ProvedoresDto.builder()
                    .CodProv(provedores.getCodProv())
                    .Descrip(provedores.getDescrip())
                    .Telef(provedores.getTelef())
                    .Direccion(provedores.getDireccion())
                    .Email(provedores.getEmail())
                    .Key(provedores.getKey())
                    .build();

            return ResponseEntity.ok(provedoresDto);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<ProvedoresDto> provedoresDtoList = provedoresServices.FindAll()
                .stream()
                .map(provedores -> ProvedoresDto.builder()
                        .CodProv(provedores.getCodProv())
                        .Descrip(provedores.getDescrip())
                        .Direccion(provedores.getDireccion())
                        .Email(provedores.getEmail())
                        .build())
                .toList();
        return ResponseEntity.ok(provedoresDtoList);
    }

    @GetMapping("/find/documents")
    public ResponseEntity<?> FindDocumentsByProviders(){
        List<ProvedoresDto> provedoresDtoList = provedoresServices.FindAll()
                .stream()
                .map(provedores -> ProvedoresDto.builder()
                        .documentosDtoList(provedores.getDocumentList())
                        .build())
                .toList();
        return ResponseEntity.ok(provedoresDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProvedoresDto provedoresDto) throws URISyntaxException {
        if(provedoresDto.getDescrip().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        provedoresServices.save(Provedores.builder()
                .Descrip(provedoresDto.getDescrip())
                        .Key(provedoresDto.getKey())
                        .Email(provedoresDto.getEmail())
                        .CodProv(provedoresDto.getCodProv())
                        .Telef(provedoresDto.getTelef())
                        .Direccion(provedoresDto.getDireccion())
                        .FechaE(provedoresDto.getDateTimeFormat())
                        .FechaMod(provedoresDto.getDate())
                .build());

        return ResponseEntity.created(new URI("api/providers/save")).build();

    }
}
