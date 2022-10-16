package com.usa.p1.controller;

import com.usa.p1.model.Message;

import com.usa.p1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestBody Message message){
        messageService.create(message);
    }

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.messages();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateMessage(@RequestBody Message message){
        messageService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable ("id") Integer id){
        messageService.delete(id);
    }
}
