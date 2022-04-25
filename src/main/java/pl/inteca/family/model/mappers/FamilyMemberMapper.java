package pl.inteca.family.model.mappers;

import org.springframework.stereotype.Service;
import pl.inteca.family.model.dtos.FamilyMemberDto;
import pl.inteca.family.model.FamilyMember;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyMemberMapper {

    public FamilyMember mapFamilyMemberDtoToFamilyMember(final FamilyMemberDto familyMemberDto){
        return new FamilyMember(
                familyMemberDto.getId(),
                familyMemberDto.getGivenName(),
                familyMemberDto.getAge(),
                familyMemberDto.getFamilyId());
    }

    public FamilyMemberDto mapFamilyMemberToFamilyMemberDto(final FamilyMember familyMember){
        return new FamilyMemberDto(
                familyMember.getId(),
                familyMember.getGivenName(),
                familyMember.getAge(),
                familyMember.getFamilyId());
    }

    public List<FamilyMember> mapFamilyMemberDtoListToFamilyMemberList(final List<FamilyMemberDto> familyMemberDtoList){
        List<FamilyMember> resultList = new ArrayList<>();
        for (FamilyMemberDto memberDto : familyMemberDtoList){
            resultList.add(mapFamilyMemberDtoToFamilyMember(memberDto));
        }
        return resultList;
    }

    public List<FamilyMemberDto> mapFamilyMemberListToFamilyMemberDtoList(final List<FamilyMember> familyMemberList){
        List<FamilyMemberDto> resultList = new ArrayList<>();
        for (FamilyMember member : familyMemberList){
            resultList.add(mapFamilyMemberToFamilyMemberDto(member));
        }
        return resultList;
    }
}
