package pl.inteca.family.model;

import javax.persistence.*;
import java.util.List;

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

}
