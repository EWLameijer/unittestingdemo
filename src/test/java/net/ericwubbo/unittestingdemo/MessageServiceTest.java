package net.ericwubbo.unittestingdemo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

// @RequiredArgsConstructor does NOT work here, "No ParameterResolver registered for parameter" need @Autowired

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void titleizeShouldCapitalizeCorrectly() {
        // ARRANGE
        var input = "core java";
        var expectedOutput = "Core Java";

        // ACT
        var actualOutput = messageService.titleize(input);

        // ASSERT
        assertEquals(expectedOutput, actualOutput);
    }
}
