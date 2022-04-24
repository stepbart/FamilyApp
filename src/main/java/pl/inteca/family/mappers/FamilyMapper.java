package pl.inteca.family.mappers;

import org.springframework.stereotype.Service;
import pl.inteca.family.dtos.FamilyDto;
import pl.inteca.family.model.Family;

@Service
public class FamilyMapper {

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
                family.getNrOfInfants());
    }

}
