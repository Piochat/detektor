package com.tumadre.service;

import com.tumadre.dao.interfaces.OwnerDaoInte;
import com.tumadre.domain.dto.AssociationVehicleOwnerDto;
import com.tumadre.domain.entity.Owner;
import com.tumadre.domain.model.OwnerModel;
import com.tumadre.service.interfaces.OwnerServiceInte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OwnerService implements OwnerServiceInte {

    @Autowired
    private OwnerDaoInte ownerDao;

    @Autowired
    RestTemplate restTemplate;
    String associationURL = "http://ASSOCIATION-MANAGEMENT/api/v1/associations/owner/";

    @Override
    public List<Owner> getAll() {
        return ownerDao.get();
    }

    @Override
    public Owner get(long id) {
        var o = ownerDao.getById(id);
        if (o.isEmpty())
            return null;

        return o.get();
    }

    @Override
    public Owner save(OwnerModel model) {
        return ownerDao.save(model);
    }

    @Override
    public Owner update(OwnerModel model, long id) {
        return ownerDao.update(model, id);
    }

    @Override
    public Boolean delete(long id) {
        ResponseEntity<AssociationVehicleOwnerDto[]> response = restTemplate.getForEntity(associationURL + id, AssociationVehicleOwnerDto[].class);
        log.info(Arrays.toString(response.getBody()));
        if (response.getStatusCode() == HttpStatus.ACCEPTED)
            return false;

        return ownerDao.delete(id);
    }
}
