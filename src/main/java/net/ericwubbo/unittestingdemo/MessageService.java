package net.ericwubbo.unittestingdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public String titleize(String originalText) {
        var result = new StringBuilder();
        for (int index = 0; index < originalText.length(); index++) {
            var currentChar = originalText.charAt(index);
            if (index == 0) result.append(Character.toUpperCase(currentChar));
            else {
                if (Character.isWhitespace(originalText.charAt(index - 1)))
                    result.append(Character.toUpperCase(currentChar));
                else result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String gigiize(String originalText) {
        var result = new StringBuilder();
        boolean nextShouldBeUpperCase = true;
        for (int index = 0; index < originalText.length(); index++) {
            var currentChar = originalText.charAt(index);
            if (!Character.isLetter(currentChar)) {
                result.append(currentChar);
            } else {
                char transformedChar = nextShouldBeUpperCase ? Character.toUpperCase(currentChar) : Character.toLowerCase(currentChar);
                result.append(transformedChar);
                nextShouldBeUpperCase = !nextShouldBeUpperCase;
            }
        }
        return result.toString();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
