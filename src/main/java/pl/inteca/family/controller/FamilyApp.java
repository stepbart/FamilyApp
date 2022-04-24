package pl.inteca.family.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.inteca.family.dtos.FamilyDto;
import pl.inteca.family.exception.NotCorrectFamilyData;
import pl.inteca.family.model.Family;
import pl.inteca.family.service.FamilyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/families")
public class FamilyApp {

    private final FamilyService familyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Family> addFamily(@RequestBody FamilyDto familyDto) throws NotCorrectFamilyData {
        return familyService.addFamily(familyDto);
    }
}
