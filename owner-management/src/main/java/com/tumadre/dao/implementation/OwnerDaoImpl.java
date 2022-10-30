package com.tumadre.dao.implementation;

import com.tumadre.dao.interfaces.OwnerDaoInte;
import com.tumadre.dao.repository.OwnerRepository;
import com.tumadre.domain.entity.Owner;
import com.tumadre.domain.model.OwnerModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OwnerDaoImpl implements OwnerDaoInte {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Optional<Owner> getById(long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public List<Owner> get() {
        return ownerRepository.findByErasedFalse();
    }

    @Override
    public Owner save(OwnerModel model) {
        Owner owner = null;
        try {
            var o = Owner.builder()
                    .address(model.getAddress())
                    .dpi(model.getDpi())
                    .erased(false)
                    .email(model.getEmail())
                    .birthdate(model.getBirthdate())
                    .firstname(model.getFirstname())
                    .lastname(model.getLastname())
                    .phone(model.getPhone())
                    .build();
            owner = ownerRepository.save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return owner;
    }

    @Override
    public Owner update(OwnerModel model, long id) {
        Owner owner = null;
        try {
            var o = Owner.builder()
                    .ownerId(id)
                    .address(model.getAddress())
                    .dpi(model.getDpi())
                    .erased(false)
                    .email(model.getEmail())
                    .birthdate(model.getBirthdate())
                    .firstname(model.getFirstname())
                    .lastname(model.getLastname())
                    .phone(model.getPhone())
                    .build();
            owner = ownerRepository.save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return owner;
    }

    @Override
    public Boolean delete(long id) {
        var o = getById(id);
        if (o.isEmpty())
            return false;

        var owner = o.get();
        owner.setErased(true);
        ownerRepository.save(owner);
        return owner.getErased();
    }
}
