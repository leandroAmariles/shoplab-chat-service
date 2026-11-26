package com.shoplab.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Conversational orchestrator of ShopLab: SSE chat, RAG citations, memory, feedback, prompts and traces (LAB-59). */
@SpringBootApplication
public class ChatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatServiceApplication.class, args);
    }
}
