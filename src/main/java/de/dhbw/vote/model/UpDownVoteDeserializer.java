package de.dhbw.vote.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.dhbw.vote.common.CustomLogger;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author codekeks
 */
public class UpDownVoteDeserializer extends StdDeserializer<UpDownVote>{
     public UpDownVoteDeserializer() { 
        this(null); 
    } 
 
    public UpDownVoteDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public UpDownVote deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        ObjectMapper objectMapper = new ObjectMapper();
        
        Long id = node.get("id").asLong();
        String description  = node.get("description").asText();
        String creator = node.get("creator").get("username").asText();
        String date = node.get("date").asText();
        Category category = Category.valueOf(Category.class, node.get("category").asText());        
                
        List<Voter> upList = objectMapper
            .readValue(
                node.get("upVotes").toString(), 
                new TypeReference<List<Voter>>(){}
            );
        List<String> upVoter = upList
            .stream()
            .map(v -> v.getUsername())
            .collect(Collectors.toList());


        List<Voter> downList = objectMapper
            .readValue(
                    node.get("downVotes").toString(), 
                    new TypeReference<List<Voter>>(){}
            );
        List<String> downVoter = downList
            .stream()
            .map(v -> v.getUsername())
            .collect(Collectors.toList());   
        int upVotes = upVoter.size();
        int downVotes = downVoter.size();
        
        return new UpDownVote(id, description, creator, upVoter, upVotes, downVoter, downVotes, date, category);
    }    
}
