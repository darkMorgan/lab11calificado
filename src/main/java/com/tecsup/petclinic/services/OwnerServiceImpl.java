package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        Owner owner = findById(id);
        ownerRepository.delete(owner);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Owner findById(Integer id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (!owner.isPresent()) {
            System.out.println("Owner not found with id " + id);
        }
        return owner.get();
    }

    /**
     *
     * @param lastName
     * @return
     */
    @Override
    public List<Owner> findByLastName(String lastName) {
        List<Owner> owners = ownerRepository.findByLastName(lastName);
        owners.forEach(owner -> log.info("" + owner));
        return owners;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
