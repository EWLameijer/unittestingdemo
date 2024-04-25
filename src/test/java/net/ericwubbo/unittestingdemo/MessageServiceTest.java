package net.ericwubbo.unittestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void titleizeShouldCapitalizeCorrectly() {
        // ARRANGE
        var input = "core java";
        var expectedOutput = "core java";

        // ACT
        var actualOutput = messageService.titleize(input);

        // ASSERT
        assertEquals(expectedOutput, actualOutput);
    }
}
