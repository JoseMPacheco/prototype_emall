package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import com.prototypelab.prototype.Persistence.iItemsDocumentosDao;
import com.prototypelab.prototype.Services.iItemsDocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsServices implements iItemsDocServices {

    @Autowired
    iItemsDocumentosDao iItemsDocumentosDao;

    @Override
    public List<ItemsDocumentos> FindAll() {
        return iItemsDocumentosDao.FindAll();
    }

    @Override
    public Optional<ItemsDocumentos> FindItemsById(Long Id) {
        return iItemsDocumentosDao.FindItemsById(Id);
    }

    @Override
    public void save(ItemsDocumentos itemsDocumentos) {
        iItemsDocumentosDao.save(itemsDocumentos);
    }

    @Override
    public void deleteById(Long Id) {
        iItemsDocumentosDao.deleteById(Id);
    }
}
