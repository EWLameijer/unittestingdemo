package net.ericwubbo.unittestingdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// @RequiredArgsConstructor does NOT work here, "No ParameterResolver registered for parameter" need @Autowired

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void titleize_should_capitalize_correctly() {
        // ARRANGE
        var input = "core java";
        var expectedOutput = "Core Java";

        // ACT
        var actualOutput = messageService.titleize(input);

        // ASSERT
        assertEquals(expectedOutput, actualOutput);
    }


    // example: see https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest
    @CsvSource(value = {"test:TeSt", "TEST:TeSt", "the lord of the rings:ThE lOrD oF tHe RiNgS"}, delimiter = ':')
    void gigiizatiob_should_work_correctly(String input, String expected) {
        // ARRANGE (done by @CsvSource)

        // ACT
        String actualValue = messageService.gigiize(input);

        // ASSERT
        assertEquals(expected, actualValue);
    }
}
