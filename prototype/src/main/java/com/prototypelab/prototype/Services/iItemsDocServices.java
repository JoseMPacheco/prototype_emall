package com.prototypelab.prototype.Services;

import com.prototypelab.prototype.Modelos.ItemsDocumentos;

import java.util.List;
import java.util.Optional;

public interface iItemsDocServices {

    List<ItemsDocumentos> FindAll();
    Optional<ItemsDocumentos> FindItemsById(Long Id);

    void save(ItemsDocumentos itemsDocumentos);

    void deleteById(Long Id);
}
