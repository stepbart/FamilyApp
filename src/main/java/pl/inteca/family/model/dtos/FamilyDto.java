package pl.inteca.family.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDto {

    private Long id;
    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;
    private List<FamilyMemberDto> familyMembers;

    public FamilyDto(String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants, List<FamilyMemberDto> familyMembers) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
        this.familyMembers = familyMembers;
    }

}
