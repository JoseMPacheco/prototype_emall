package com.prototypelab.prototype.Controllers;


import com.prototypelab.prototype.Controllers.Dto.ClientesDto;
import com.prototypelab.prototype.Controllers.Dto.DocumentosDto;
import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Modelos.Documentos;
import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Services.IDocumentosServices;
import com.prototypelab.prototype.Services.iItemsDocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/documents")
public class DocumentosControllers {

    @Autowired
    IDocumentosServices documentosServices;

    @GetMapping("/findId/{id}")
    public ResponseEntity<?> FindById(@PathVariable String id){
        Optional<Documentos> optional = documentosServices.FindDocumentById(id);

        if(optional.isPresent()){
            Documentos documentos = optional.get();
            DocumentosDto documentosdto = DocumentosDto.builder()
                    .NumeroDoc(documentos.getNumeroDoc())
                    .Factor(documentos.getFactor())
                    .MontoGravable(documentos.getMontoGravable())
                    .MontoTax(documentos.getMontoTax())
                    .MontoTotal(documentos.getMontoTotal())
                    .status(documentos.isStatus())
                    .build();

            return ResponseEntity.ok(documentosdto);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<DocumentosDto> documentosDtoList = documentosServices.FindAll()
                .stream()
                .map(documentos -> DocumentosDto.builder()
                        .NumeroDoc(documentos.getNumeroDoc())
                        .Factor(documentos.getFactor())
                        .MontoTax(documentos.getMontoTax())
                        .MontoGravable(documentos.getMontoGravable())
                        .MontoTotal(documentos.getMontoTotal())
                        .status(documentos.isStatus())
                        .ClienteId(documentos.getClientes().getIdentificadorCliente())
                        .ProvedorId(documentos.getProvedores().getCodProv())
                        .build())
                .toList();
        return ResponseEntity.ok(documentosDtoList);
    }
    @GetMapping("/find/items")
    public ResponseEntity<?> FindAllItems(){
        List<DocumentosDto> documentosDtoList = documentosServices.FindAll()
                .stream()
                .map(documentos -> DocumentosDto.builder()
                        .NumeroDoc(documentos.getNumeroDoc())
                        .Factor(documentos.getFactor())
                        .MontoTax(documentos.getMontoTax())
                        .MontoGravable(documentos.getMontoGravable())
                        .MontoTotal(documentos.getMontoTotal())
                        .status(documentos.isStatus())
                        .itemsDocumentosList(documentos.getItemsDocumentosList())
                        .build())
                .toList();
        return ResponseEntity.ok(documentosDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DocumentosDto documentosDto) throws URISyntaxException {
        if(documentosDto.getNumeroDoc().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        documentosServices.save(Documentos.builder()
                .NumeroDoc(documentosDto.getNumeroDoc())
                .MontoTax(documentosDto.getMontoTax())
                .Factor(documentosDto.getFactor())
                .MontoTotal(documentosDto.getMontoTotal())
                .MontoGravable(documentosDto.getMontoGravable())
                .status(documentosDto.isStatus())
                .provedores(Provedores.builder().CodProv(documentosDto.getProvedorId()).build())
                .clientes(Clientes.builder().IdentificadorCliente(documentosDto.getClienteId()).build())
                .build());

        return ResponseEntity.created(new URI("api/documents/save")).build();

    }


}
