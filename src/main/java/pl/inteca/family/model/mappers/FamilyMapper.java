package pl.inteca.family.model.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.model.Family;

@Service
@RequiredArgsConstructor
public class FamilyMapper {

    private final FamilyMemberMapper familyMemberMapper;

    public Family mapFamilyDtoToFamily(final FamilyDto familyDto){
        return new Family(
                familyDto.getId(),
                familyDto.getFamilyName(),
                familyDto.getNrOfAdults(),
                familyDto.getNrOfChildren(),
                familyDto.getNrOfInfants());
    }

    public FamilyDto mapFamilyToFamilyDto(final Family family){
        return new FamilyDto(
                family.getId(),
                family.getFamilyName(),
                family.getNrOfAdults(),
                family.getNrOfChildren(),
                family.getNrOfInfants(),
                familyMemberMapper.mapFamilyMemberListToFamilyMemberDtoList(family.getFamilyMembers()));
    }

}
