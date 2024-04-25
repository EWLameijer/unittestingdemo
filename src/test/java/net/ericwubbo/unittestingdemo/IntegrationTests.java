package net.ericwubbo.unittestingdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest( // Note: @SpringBootTest doesn't work nicely with @WebMvcTest
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = UnitTestingDemoApplication.class
)
@AutoConfigureMockMvc
public class IntegrationTests {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_that_message_is_written_and_gets_an_id() {
        // ARRANGE
        var message = new Message("hello");

        // ACT
        messageRepository.save(message);

        // ASSERT
        assertNotNull(message.getId());
        assertEquals(message.getTitle(), "hello");
    }

    @Test
    public void test_that_gigiize_saves_a_message() throws Exception {
        Message ej = new Message("effective java");

        mvc.perform(post("/gigi-ize") // gigi-ize does not work
                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(ej)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("x")));
    }

    // DEMO: How to deal with array results
//    @Test
//    public void test2_that_gigiize_saves_a_message() throws Exception {
//
//        mvc.perform(get("/") // gigi-ize does not work
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is("x")));
//    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
