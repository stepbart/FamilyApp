package pl.inteca.family.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.inteca.family.model.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
}
