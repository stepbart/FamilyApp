package pl.inteca.family.model;

import javax.persistence.*;

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


}
