package com.example.demo.listener.impl;

import com.example.demo.listener.PlayListen;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class Plays implements PlayListen {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent){
        if (messageCreateEvent.getMessageContent().equals("/4")){
            messageCreateEvent.getChannel().sendMessage("initiated play");
        }
    }
}
