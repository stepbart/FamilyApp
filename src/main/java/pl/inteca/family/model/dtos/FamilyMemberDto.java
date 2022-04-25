package pl.inteca.family.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FamilyMemberDto {

    private Long id;
    private String givenName;
    private int age;
    private Long familyId;
}
