package com.tumadre.service.interfaces;

import com.tumadre.domain.entity.Owner;
import com.tumadre.domain.model.OwnerModel;

import java.util.List;

public interface OwnerServiceInte {

    public List<Owner> getAll();

    public Owner get(long id);

    public Owner save(OwnerModel model);

    public Owner update(OwnerModel model, long id);

    public Boolean delete(long id);
}
