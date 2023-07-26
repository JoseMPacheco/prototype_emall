package com.prototypelab.prototype.Controllers;


import com.prototypelab.prototype.Controllers.Dto.ItemsDto;
import com.prototypelab.prototype.Controllers.Dto.TransaccionesDto;
import com.prototypelab.prototype.Modelos.Documentos;
import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import com.prototypelab.prototype.Modelos.Transacciones;
import com.prototypelab.prototype.Services.iItemsDocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/items")
public class ItemsController {
    @Autowired
    iItemsDocServices itemsDocServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindById(@PathVariable Long id){
        Optional<ItemsDocumentos> optional = itemsDocServices.FindItemsById(id);

        if(optional.isPresent()){
            ItemsDocumentos itemsDocumentos = optional.get();
            ItemsDto itemsDto = ItemsDto.builder()
                    .Id(itemsDocumentos.getId())
                    .cantidad(itemsDocumentos.getCantidad())
                    .Descripcion(itemsDocumentos.getDescripcion())
                    .Descripcion2(itemsDocumentos.getDescripcion2())
                    .CodProd(itemsDocumentos.getCodProd())
                    .NroLinea(itemsDocumentos.getNroLinea())
                    .precioBs(itemsDocumentos.getPrecioBs())
                    .precioRef(itemsDocumentos.getPrecioRef())
                    .NumeroDoc(itemsDocumentos.getDocumentos().getNumeroDoc())
                    .build();


            return ResponseEntity.ok(itemsDto);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<ItemsDto> itemsDtos = itemsDocServices.FindAll()
                .stream()
                .map(itemsDocumentos -> ItemsDto.builder()
                        .cantidad(itemsDocumentos.getCantidad())
                        .Descripcion(itemsDocumentos.getDescripcion())
                        .Descripcion2(itemsDocumentos.getDescripcion2())
                        .CodProd(itemsDocumentos.getCodProd())
                        .NroLinea(itemsDocumentos.getNroLinea())
                        .precioBs(itemsDocumentos.getPrecioBs())
                        .precioRef(itemsDocumentos.getPrecioRef())
                        .NumeroDoc(itemsDocumentos.getDocumentos().getNumeroDoc())
                        .build()
                ).toList();
        return ResponseEntity.ok(itemsDtos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ItemsDto itemsDocumentos) throws URISyntaxException {
        if(itemsDocumentos.getDescripcion().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        itemsDocServices.save(ItemsDocumentos.builder()
                .Descripcion(itemsDocumentos.getDescripcion())
                .Id(itemsDocumentos.getId())
                .NroLinea(itemsDocumentos.getNroLinea())
                .precioBs(itemsDocumentos.getPrecioBs())
                .precioRef(itemsDocumentos.getPrecioRef())
                .Descripcion2(itemsDocumentos.getDescripcion2())
                .CodProd(itemsDocumentos.getCodProd())
                .documentos(Documentos.builder().NumeroDoc(itemsDocumentos.getNumeroDoc()).build())
                .build());

        return ResponseEntity.created(new URI("api/items/save")).build();

    }
}
