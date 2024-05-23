package net.ericwubbo.unittestingdemo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RequiredArgsConstructor
public class MessageServiceTest {

    private final MessageService messageService;

    @Test
    public void toTitleCase_should_capitalize_correctly() {
        // ARRANGE
        var input = "core java";
        var expectedOutput = "core java";

        // ACT
        var actualOutput = messageService.toTitleCase(input);

        // ASSERT
        org.junit.jupiter.api.Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
