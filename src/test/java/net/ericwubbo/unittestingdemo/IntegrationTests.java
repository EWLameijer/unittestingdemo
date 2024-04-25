package net.ericwubbo.unittestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class IntegrationTests {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test_that_message_is_written_and_gets_an_id() {
        // ARRANGE
        var message = new Message("hello");

        // ACT
        messageRepository.save(message);

        // ASSERT
        assertNull(message.getId());
        assertEquals(message.getTitle(), "hello");
    }

}
