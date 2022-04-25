package pl.inteca.family.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.model.dtos.FamilyMemberDto;
import pl.inteca.family.model.mappers.FamilyMemberMapper;
import pl.inteca.family.model.FamilyMember;
import pl.inteca.family.repositories.FamilyMemberRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FamilyMemberService {

    private final FamilyMemberMapper familyMemberMapper;
    private final FamilyMemberRepository familyMemberRepository;

    public ResponseEntity createFamilyMember(FamilyDto familyDto, Long id) {
            for (FamilyMemberDto member : familyDto.getFamilyMembers())
            {
                addMember(member,familyDto, id);
            }
            return ResponseEntity.ok(familyDto);
    }

    private void addMember(FamilyMemberDto member, FamilyDto familyDto, Long id) {
        FamilyMember familyMember = familyMemberMapper.mapFamilyMemberDtoToFamilyMember(member);
        familyMember.setFamilyId(id);
        familyMember.setFamilyName(familyDto.getFamilyName());
        familyMemberRepository.save(familyMember);
    }

    public List<FamilyMemberDto> searchFamilyMember(Long id) {
        return familyMemberMapper.mapFamilyMemberListToFamilyMemberDtoList(familyMemberRepository.findAllByFamilyId(id));
    }
}
