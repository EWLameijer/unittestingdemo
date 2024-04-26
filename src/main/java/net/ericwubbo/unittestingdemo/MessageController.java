package net.ericwubbo.unittestingdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessageController {

    final MessageService messageService;

    final MessageRepository messageRepository;

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable UUID id) {
        return messageRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Message capitalize(@RequestBody Message message) {
        var capitalizedTitle = messageService.titleize(message.getTitle());
        message.setTitle(capitalizedTitle);
        return message;
    }

    @PostMapping("gigi-ize")
    public Message gigiize(@RequestBody Message message) {
        var gigiizedTitle = messageService.gigiize(message.getTitle());
        message.setTitle(gigiizedTitle);
        return messageService.save(message);
    }
}
