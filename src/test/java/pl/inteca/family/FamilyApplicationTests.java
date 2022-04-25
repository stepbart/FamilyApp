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
class FamilyApplicationTests {

    @Test
    void contextLoads() {
    }
}
