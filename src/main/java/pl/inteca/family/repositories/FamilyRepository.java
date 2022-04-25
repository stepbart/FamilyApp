package pl.inteca.family.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.inteca.family.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {

}
