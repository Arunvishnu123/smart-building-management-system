package com.project.smartbuidingapp.Building;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.smartbuidingapp.Window.WindowController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BuildingController.class)
public class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingService buildingService;

    String token;

    @BeforeEach
    void setUp() throws Exception {
        String username = "admin";
        String password = "12345";

        String body = "{\"username\":\"" + username + "\" , \"password\":"
                + password + "\" }";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"access_token\": \"", "");
        token = response.replace("\"}", "");

        System.out.println(token);
    }
    @Test
     void canGetBuildingList() throws Exception {
        BuildingEntity buildingEntity1 = new BuildingEntity ( 2L,5L, "Mines", "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        BuildingEntity  buildingEntity2 = new BuildingEntity ( 1L,6L, "Mines", "Saint-Etienne", "Arun", "9", "structural", 1000L, 8);
        List<BuildingEntity > buildingList = new ArrayList<>();
        buildingList.add(buildingEntity1);
        buildingList.add(buildingEntity2);

        List<BuildingDto>  buildingDtos =  buildingList.stream().map(BuildingDto::new).collect(Collectors.toList());
        Mockito.when(buildingService.getAllBuildings()).thenReturn(buildingDtos);
        String URI = "/login";

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =  MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer"  + token );

        MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();

       String expectedJson = this.mapToJson(buildingList);
       String outputInJson = result.getResponse().getContentAsString();

       // System.out.println("test1"+expectedJson);
        System.out.println("test" + result.getResponse().getStatus() );
       assertThat(expectedJson).isEqualTo(outputInJson);
    }


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
