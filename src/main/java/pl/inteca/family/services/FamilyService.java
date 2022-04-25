package pl.inteca.family.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.model.dtos.FamilyMemberDto;
import pl.inteca.family.exceptions.NotCorrectFamilyData;
import pl.inteca.family.exceptions.NotCorrectFamilyId;
import pl.inteca.family.model.mappers.FamilyMapper;
import pl.inteca.family.model.Family;
import pl.inteca.family.repositories.FamilyRepository;

@RequiredArgsConstructor
@Service
public class FamilyService {
    
    private final FamilyMapper familyMapper;
    private final FamilyRepository familyRepository;
    private final FamilyMemberService familyMemberService;

    public ResponseEntity createFamily(FamilyDto familyDto) throws NotCorrectFamilyData {
        if (!validateFamilyData(familyDto))
        {
            throw new NotCorrectFamilyData();
        }
        else
        {
            Family family = familyMapper.mapFamilyDtoToFamily(familyDto);
            familyRepository.save(family);
            familyMemberService.createFamilyMember(familyDto, family.getId());
            return ResponseEntity.ok(familyDto);
        }
    }

    public boolean validateFamilyData(FamilyDto familyDto) {
        int adultCheck = 0;
        int childrenCheck = 0;
        int infantsCheck = 0;
        for (FamilyMemberDto member : familyDto.getFamilyMembers())
        {
            if (member.getAge()>=0 && member.getAge()<=4)
            {
                infantsCheck++;
            }
            if (member.getAge()>4 && member.getAge()<=16)
            {
                childrenCheck++;
            }
            if (member.getAge()>16)
            {
                adultCheck++;
            }
        }
        if (familyDto.getNrOfAdults()==adultCheck &&
                familyDto.getNrOfChildren()==childrenCheck &&
                familyDto.getNrOfInfants()==infantsCheck)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ResponseEntity<FamilyDto> getFamily(Long id) {
        try{
            FamilyDto familyDto = familyMapper.mapFamilyToFamilyDto(familyRepository.findById(id).orElseThrow(NotCorrectFamilyId::new));
            familyDto.setFamilyMembers(familyMemberService.searchFamilyMember(id));
            return ResponseEntity.ok(familyDto);
        }
        catch (NotCorrectFamilyId exception){
            return ResponseEntity.badRequest().build();
        }
    }
}
