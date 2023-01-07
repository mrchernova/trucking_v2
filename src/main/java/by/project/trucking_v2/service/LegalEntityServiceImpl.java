package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.LegalEntityRepository;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalEntityServiceImpl implements LegalEntityService {
    @Autowired
    LegalEntityRepository legalEntityRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<LegalEntity> getAll() {
        Iterable<LegalEntity> iterable = legalEntityRepository.findAll();

        System.out.println("***************1*******************");
        System.out.println(iterable);
        System.out.println("****************2******************");

        List<LegalEntity> legalEntities = Streamable.of(iterable).toList();

        return legalEntities;
    }

    @Override
    public LegalEntity findById(int id) {
    //    return legalEntityRepository.findById(id).orElseThrow(() -> new NotFoundException("мы не знаем что это такое, если бы мы знали что это такое, мы не знаем что это такое"));
//        LegalEntity le = legalEntityRepository.findById(id).orElseThrow(() -> new SomeException());
        LegalEntity le = legalEntityRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return le;
    }

    @Override
    public LegalEntity save(LegalEntity legalEntity, int userId) {
        User detectedUser = userRepository.findById(userId).orElseThrow();

        LegalEntity newLegalEntity = LegalEntity.builder()
                .title(legalEntity.getTitle())
                .contact(legalEntity.getContact())
                .build();

        return legalEntityRepository.save(newLegalEntity);
    }


    @Override
    public LegalEntity update(int id, LegalEntity legalEntity) {

        LegalEntity currentLegalEntity = legalEntityRepository.findById(id).orElseThrow();

        currentLegalEntity.setTitle(legalEntity.getTitle());
        currentLegalEntity.setContact(legalEntity.getContact());

        return legalEntityRepository.save(currentLegalEntity);
    }

    @Override
    public void delete(int id) {
        legalEntityRepository.deleteById(id);
    }

}