package pl.inteca.family.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "FAMILIES")
public class Family {

    @Id
    @GeneratedValue
    private Long id;
    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;

    @OneToMany(
            targetEntity = FamilyMember.class,
            mappedBy = "family",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<FamilyMember> familyMembers;

    public Family(String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public Family(Long id, String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants) {
        this.id = id;
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public Family(Long id, String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants, List<FamilyMember> familyMembers) {
        this.id = id;
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
        this.familyMembers = familyMembers;
    }
}
