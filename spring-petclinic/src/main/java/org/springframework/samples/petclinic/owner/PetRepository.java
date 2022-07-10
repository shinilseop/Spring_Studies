package org.springframework.samples.petclinic.owner;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.repository.Repository;

public interface PetRepository extends Repository<Pet, Long> {

}
