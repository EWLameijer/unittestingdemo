package net.ericwubbo.unittestingdemo;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String titleize(String originalText) {
        var result = new StringBuilder();
        for (int index=0; index < originalText.length(); index++) {
            var currentChar = originalText.charAt(index);
            if (index == 0) result.append(Character.toUpperCase(currentChar));
            else {
                if (Character.isWhitespace(originalText.charAt(index - 1))) result.append(Character.toUpperCase(currentChar));
                else result.append(currentChar);
            }
        }
        return result.toString();
    }
}
