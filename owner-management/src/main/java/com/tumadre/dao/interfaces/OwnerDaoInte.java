package com.tumadre.dao.interfaces;

import com.tumadre.domain.entity.Owner;
import com.tumadre.domain.model.OwnerModel;

import java.util.List;
import java.util.Optional;

public interface OwnerDaoInte {

    public Optional<Owner> getById(long id);

    public List<Owner> get();

    public Owner save(OwnerModel model);

    public Owner update(OwnerModel model, long id);

    public Boolean delete(long id);
}
