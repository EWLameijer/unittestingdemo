package net.ericwubbo.unittestingdemo;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {
    public String toTitleCase(String originalText) {
        List<String> capitalizedWords = Arrays.stream(originalText.split("\\s+")).map(this::capitalize).toList();
        return String.join(" ", capitalizedWords);
    }

    private String capitalize(String word) {
        if (word == null || word.isEmpty()) return "";
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
