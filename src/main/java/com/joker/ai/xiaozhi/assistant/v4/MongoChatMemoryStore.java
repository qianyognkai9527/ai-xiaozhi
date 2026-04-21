package com.joker.ai.xiaozhi.assistant.v4;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);
        ChatMessages chatMessages = mongoTemplate.findOne(query, ChatMessages.class);
        if (Objects.isNull(chatMessages)){
            return new LinkedList<>();
        }

        List<ChatMessage> chatMessagesList = ChatMessageDeserializer.messagesFromJson(chatMessages.getContent());
        return chatMessagesList;
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);

        Update update = new Update();
        update.set("content", ChatMessageSerializer.messagesToJson( messages));
        mongoTemplate.upsert(query, update, ChatMessages.class);

    }

    @Override
    public void deleteMessages(Object memoryId) {
        Criteria criteria =  Criteria.where("query").is(memoryId);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);

    }
}
