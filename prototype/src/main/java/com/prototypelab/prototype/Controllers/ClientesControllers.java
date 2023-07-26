package com.prototypelab.prototype.Controllers;


import com.prototypelab.prototype.Controllers.Dto.ClientesDto;
import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Services.IClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clients")
public class ClientesControllers {

    @Autowired
    IClientesServices clientesServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindById(@PathVariable String id){
        Optional<Clientes> optionalClientes = clientesServices.FindClientesByid(id);

        if(optionalClientes.isPresent()){
            Clientes clientes = optionalClientes.get();
            ClientesDto clientesDto = ClientesDto.builder()
                    .CodigoCliente(clientes.getIdentificadorCliente())
                    .Email(clientes.getEmail())
                    .Descripcion(clientes.getDescripcion())
                    .Id(clientes.getId())
                    .build();

            return ResponseEntity.ok(clientes);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/find")
    public ResponseEntity<?> FindAll(){
        List<ClientesDto> clientesDtoList = clientesServices.FindAll()
                .stream()
                .map(clientes -> ClientesDto.builder()
                        .Id(clientes.getId())
                        .CodigoCliente(clientes.getIdentificadorCliente())
                        .Descripcion(clientes.getDescripcion())
                        .Email(clientes.getEmail())
                        .build())
                .toList();
        return ResponseEntity.ok(clientesDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClientesDto clientesDto) throws URISyntaxException {
        if(clientesDto.getDescripcion().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        clientesServices.save(Clientes.builder()
                        .Descripcion(clientesDto.getDescripcion())
                        .build());

        return ResponseEntity.created(new URI("api/clients/save")).build();

    }
}
