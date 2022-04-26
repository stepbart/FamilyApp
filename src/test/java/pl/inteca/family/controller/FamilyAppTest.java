package pl.inteca.family.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.model.dtos.FamilyMemberDto;
import pl.inteca.family.services.FamilyService;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(FamilyApp.class)
class FamilyAppTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FamilyService service;

    @Test
    void shouldGetFamily() throws Exception {
        //Given
        FamilyMemberDto familyMember1 = new FamilyMemberDto(1L,"Smith", 52);
        FamilyMemberDto familyMember2 = new FamilyMemberDto(2L,"Smith", 48);
        FamilyMemberDto familyMember3 = new FamilyMemberDto(3L,"Smith", 24);
        FamilyMemberDto familyMember4 = new FamilyMemberDto(4L,"Smith", 13);
        FamilyMemberDto familyMember5 = new FamilyMemberDto(5L,"Smith", 3);

        List<FamilyMemberDto> familyMembers = new ArrayList<>();
        familyMembers.add(familyMember1);
        familyMembers.add(familyMember2);
        familyMembers.add(familyMember3);
        familyMembers.add(familyMember4);
        familyMembers.add(familyMember5);

        FamilyDto family = new FamilyDto(12L,"Smith",1,1,0,familyMembers);
        ResponseEntity<FamilyDto> familyDtoResponseEntity = ResponseEntity.ok(family);

        //When & Then
        when(service.getFamily(12L)).thenReturn(familyDtoResponseEntity);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1.0/families/12")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}