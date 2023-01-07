package by.project.trucking_v2.service;

import by.project.trucking_v2.model.LegalEntity;

import java.util.List;

public interface LegalEntityService {

    List<LegalEntity> getAll();

    LegalEntity findById(int id);

    LegalEntity save(LegalEntity legalEntity, int userId);

    LegalEntity update(int id, LegalEntity legalEntity);

    void delete(int id);

}