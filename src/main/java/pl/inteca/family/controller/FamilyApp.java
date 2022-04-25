package pl.inteca.family.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.exceptions.NotCorrectFamilyData;
import pl.inteca.family.model.Family;
import pl.inteca.family.services.FamilyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/families")
public class FamilyApp {

    private final FamilyService familyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Family> createFamily(
            @RequestBody FamilyDto familyDto) throws NotCorrectFamilyData {
        return familyService.createFamily(familyDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDto> getFamily(@PathVariable Long id){
        return familyService.getFamily(id);
    }
}
