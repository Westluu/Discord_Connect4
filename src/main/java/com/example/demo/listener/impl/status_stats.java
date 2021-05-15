package com.example.demo.listener.impl;

import com.example.demo.listener.status;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class status_stats implements status {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent){
        if(messageCreateEvent.getMessageContent().equals("/status")){
            messageCreateEvent.getChannel().sendMessage("Here is your status");
        }
    }
}
