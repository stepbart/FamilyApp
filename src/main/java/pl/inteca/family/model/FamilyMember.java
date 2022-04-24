package pl.inteca.family.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "FAMILY_MEMBERS")
public class FamilyMember {

    @Id
    @GeneratedValue
    private Long id;
    private String familyName;
    private String givenName;
    private Long familyId;
    @ManyToOne
    @JoinColumn(name = "FAMILIES_ID")
    private Family family;

    public FamilyMember(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
    }
}
