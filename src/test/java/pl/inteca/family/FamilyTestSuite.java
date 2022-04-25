package pl.inteca.family;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.inteca.family.model.Family;
import pl.inteca.family.model.FamilyMember;
import pl.inteca.family.repositories.FamilyMemberRepository;
import pl.inteca.family.repositories.FamilyRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FamilyTestSuite {

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    FamilyMemberRepository familyMemberRepository;

    @Test
    void testFamilyAndMembersRelations() {
        //Given
        Family family1 = new Family("Smith",2,0,0);
        Family family2 = new Family("Johnson",3,1,1);

        FamilyMember familyMember1 = new FamilyMember("Smith","Smith");
        FamilyMember familyMember2 = new FamilyMember("Smith","Johnson");
        FamilyMember familyMember3 = new FamilyMember("Johnson","Johnson");
        FamilyMember familyMember4 = new FamilyMember("Johnson","Smith");

        List<FamilyMember> familyMembers1 = new ArrayList<>();
        List<FamilyMember> familyMembers2 = new ArrayList<>();
        familyMembers1.add(familyMember1);
        familyMembers1.add(familyMember2);
        familyMembers2.add(familyMember3);
        familyMembers2.add(familyMember4);

        family1.setFamilyMembers(familyMembers1);
        family2.setFamilyMembers(familyMembers2);
        familyMember1.setFamily(family1);
        familyMember2.setFamily(family1);
        familyMember3.setFamily(family2);
        familyMember4.setFamily(family2);

        //When
        familyRepository.save(family1);
        familyRepository.save(family2);
        Long id1 = family1.getId();
        Long id2 = family2.getId();
        Long id3 = familyMember1.getId();
        Long id4 = familyMember2.getId();
        Long id5 = familyMember3.getId();
        Long id6 = familyMember4.getId();

        //Then
        Assertions.assertNotEquals(0,id1);
        Assertions.assertNotEquals(0,id2);
        Assertions.assertNotEquals(0,id3);
        Assertions.assertNotEquals(0,id4);
        Assertions.assertNotEquals(0,id5);
        Assertions.assertNotEquals(0,id6);

        //CleanUp
        familyMemberRepository.deleteById(id3);
        familyMemberRepository.deleteById(id4);
        familyMemberRepository.deleteById(id5);
        familyMemberRepository.deleteById(id6);
        familyRepository.deleteById(id1);
        familyRepository.deleteById(id2);
    }
}
