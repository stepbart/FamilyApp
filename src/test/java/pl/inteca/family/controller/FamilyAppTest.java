package pl.inteca.family.controller;

import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.inteca.family.exceptions.NotCorrectFamilyData;
import pl.inteca.family.model.dtos.FamilyDto;
import pl.inteca.family.model.dtos.FamilyMemberDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(FamilyApp.class)
class FamilyAppTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FamilyApp familyApp;

    @Test
    void createFamily() {
    }

    @Test
    void getFamily() {
    }
}