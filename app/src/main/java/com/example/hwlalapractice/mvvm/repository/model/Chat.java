package com.example.hwlalapractice.mvvm.repository.model;

public class Chat {
    private String name, lastMessage;
    private int totalMessages;

    public Chat(String name, String lastMessage, int totalMessages) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.totalMessages = totalMessages;
    }

    public String getName() {
        return name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getTotalMessages() {
        return totalMessages;
    }
}
