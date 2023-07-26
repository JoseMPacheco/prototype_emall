package com.prototypelab.prototype.Persistence;

import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Modelos.Transacciones;

import java.util.List;
import java.util.Optional;

public interface iTransaccionesDao {

    List<Transacciones> FindAll();
    Optional<Transacciones> FindById(Long Id);

    void save(Transacciones transacciones);

    void deleteById(Long Id);
}
