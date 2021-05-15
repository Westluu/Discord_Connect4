package com.example.demo.listener;

import com.example.demo.listener.impl.PlayListen;
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
