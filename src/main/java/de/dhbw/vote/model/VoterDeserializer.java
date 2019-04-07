/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.vote.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 *
 * @author codekeks
 */
public class VoterDeserializer extends StdDeserializer<Voter> {
    public VoterDeserializer() { 
        this(null); 
    } 
 
    public VoterDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Voter deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        
        String username = node.get("username").asText();
        String mail = node.get("mail").asText();
        String prename = node.get("prename").asText();
        String name = node.get("name").asText();
        int age = node.get("age").asInt();
        Sex sex = Sex.valueOf(Sex.class, node.get("sex").asText());
 
        return new Voter(username, mail, prename, name, age, sex);
    }    
}
