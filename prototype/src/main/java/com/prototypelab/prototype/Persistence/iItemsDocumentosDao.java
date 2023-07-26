package com.prototypelab.prototype.Persistence;

import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import com.prototypelab.prototype.Modelos.TipoClientes;

import java.util.List;
import java.util.Optional;

public interface iItemsDocumentosDao {

    List<ItemsDocumentos> FindAll();
    Optional<ItemsDocumentos> FindItemsById(Long Id);

    void save(ItemsDocumentos itemsDocumentos);

    void deleteById(Long Id);
}
