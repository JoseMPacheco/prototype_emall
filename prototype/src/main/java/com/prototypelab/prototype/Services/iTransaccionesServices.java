package com.prototypelab.prototype.Services;

import com.prototypelab.prototype.Modelos.Transacciones;

import java.util.List;
import java.util.Optional;

public interface iTransaccionesServices {


    List<Transacciones> FindAll();
    Optional<Transacciones> FindById(Long Id);

    void save(Transacciones transacciones);

    void deleteById(Long Id);
}
