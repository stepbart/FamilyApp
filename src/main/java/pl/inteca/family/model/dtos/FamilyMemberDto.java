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

    public FamilyMemberDto(Long id, String givenName, int age) {
        this.id = id;
        this.givenName = givenName;
        this.age = age;
    }
}
