package pl.inteca.family.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.inteca.family.dtos.FamilyDto;
import pl.inteca.family.exception.NotCorrectFamilyData;
import pl.inteca.family.mappers.FamilyMapper;
import pl.inteca.family.model.Family;
import pl.inteca.family.repositories.FamilyRepository;

@RequiredArgsConstructor
@Service
public class FamilyService {
    
    private final FamilyMapper familyMapper;
    private final FamilyRepository familyRepository;


    public ResponseEntity<Family> addFamily(FamilyDto familyDto) throws NotCorrectFamilyData {
        if (!validateFamily(familyDto)){
            throw new NotCorrectFamilyData();
        }
        else {
            return ResponseEntity.ok(familyRepository.save(familyMapper.mapFamilyDtoToFamily(familyDto)));
        }

    }

    private boolean validateFamily(FamilyDto familyDto) {
        if (familyDto.getNrOfAdults() >=1 && familyDto.getNrOfChildren() >=0 && familyDto.getNrOfInfants() >= 0){
            return true;
        }
        else {
            return false;
        }
    }
}
