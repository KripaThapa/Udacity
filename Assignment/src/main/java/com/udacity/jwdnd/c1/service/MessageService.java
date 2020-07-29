package com.udacity.jwdnd.c1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private List<String> messages;

    public MessageService() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }
}

