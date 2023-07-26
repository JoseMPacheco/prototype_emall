package com.prototypelab.prototype.Persistence.Impl;


import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import com.prototypelab.prototype.Repositories.ItemsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prototypelab.prototype.Persistence.iItemsDocumentosDao;

import java.util.List;
import java.util.Optional;

@Component
public class ItemsDocumentosDaoImpl implements iItemsDocumentosDao {

    @Autowired
    ItemsRepositories itemsRepositories;
    @Override
    public List<ItemsDocumentos> FindAll() {
        return (List<ItemsDocumentos>) itemsRepositories.findAll();
    }

    @Override
    public Optional<ItemsDocumentos> FindItemsById(Long Id) {
        return itemsRepositories.findById(Id);
    }

    @Override
    public void save(ItemsDocumentos itemsDocumentos) {
        itemsRepositories.save(itemsDocumentos);
    }

    @Override
    public void deleteById(Long Id) {
        itemsRepositories.deleteById(Id);
    }
}
