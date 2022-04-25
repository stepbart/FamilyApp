package pl.inteca.family.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.inteca.family.model.FamilyMember;

import java.util.List;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

    List<FamilyMember> findAllByFamilyId(Long id);
}
