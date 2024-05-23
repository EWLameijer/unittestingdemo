package net.ericwubbo.unittestingdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    final MessageService messageService;

    @PostMapping
    public Message capitalize(@RequestBody Message message) {
        var capitalizedTitle = messageService.toTitleCase(message.getTitle());
        message.setTitle(capitalizedTitle);
        return message;
    }
}
