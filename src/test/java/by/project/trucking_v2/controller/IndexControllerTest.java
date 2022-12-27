package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IndexController.class)
class IndexControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository repo;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void given_user_created() throws Exception {

        User userMock = new User(1L, "login", "pass", Role.CLIENT);

        String expectedResponse = mapper.writeValueAsString(userMock);

        when(repo.save(any())).thenReturn(userMock);

        mvc.perform(get("/create_user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedResponse)));
    }

}