package net.ericwubbo.unittestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void toTitleCase_should_capitalize_correctly() {
        // ARRANGE
        var input = "core java";
        var expectedOutput = "core java";

        // ACT
        var actualOutput = messageService.toTitleCase(input);

        // ASSERT
        assertEquals(expectedOutput, actualOutput);
    }
}
