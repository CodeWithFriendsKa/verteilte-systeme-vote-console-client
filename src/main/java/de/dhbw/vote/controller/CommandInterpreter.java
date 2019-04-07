package de.dhbw.vote.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.dhbw.vote.view.ContentViewer;
import de.dhbw.vote.common.CustomLogger;
import de.dhbw.vote.model.UpDownVote;
import de.dhbw.vote.model.Voter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author codekeks
 */
public class CommandInterpreter {
    
    private final  ContentViewer content;
    private static final CustomLogger logger = new CustomLogger(CommandInterpreter.class);
    private static final String URL_API = "http://localhost:8080/vote/api";
    private static final String URL_VOTES = "http://localhost:8080/vote/api/UpDownVote/";
    private static final String URL_VOTER = "http://localhost:8080/vote/api/Voter/";
    
    public CommandInterpreter() throws IOException {
        this.content = new ContentViewer();
        
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                        = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    
    public void interpret(String command) throws IOException, UnirestException{
        if(command.equals("quit")){
            this.quit();
        }
        else if(command.equals("clear")){
            this.clearScreen();
        }
        else if(command.equals("get voter -all")){
            this.getAllVoter();
        }
        else if(command.equals("get updownvote -all")){
            this.getAllUpDownVotes();
        }        
        else if(command.contains("get updownvote -username")){
            String username = command.substring(26, command.length());
            username = username.trim();
            this.getUpDownVotesByUsername(username);
        }
        else if(command.contains("get voter -username")){
            String username = command.substring(21, command.length());
            username = username.trim();
            this.getVoterByUsername(username);
        }
        else{
            this.cannotInterpret();
        }
    }
    
    public void clearScreen() throws IOException{
        System.out.print("\033[H\033[2J");
        content.showTitleAndMenue();
        content.showWaitForCommand();
    }
    
    public void quit() throws IOException{
        clearScreen();     
        content.goodBye();
        logger.debug("Console quit");
        System.exit(0);
    }
    
    public void errorWaitForCommand(){
        System.out.println();
        content.showWaitForCommand();
    }
    
    public void cannotInterpret() throws IOException{
        content.showCannotInterpret();
        content.showWaitForCommand();
    }
    
    public void getAllVoter() throws UnirestException{
        HttpResponse<Voter[]> response = Unirest.get(URL_VOTER).asObject(Voter[].class);
        List<Voter> voters = Arrays.asList(response.getBody());
        voters.forEach(v -> System.out.println(v.toString()));
    }
    public void getAllUpDownVotes() throws UnirestException{
        HttpResponse<UpDownVote[]> response = Unirest.get(URL_VOTES).asObject(UpDownVote[].class);
        List<UpDownVote> votes = Arrays.asList(response.getBody());
        votes.forEach(v-> System.out.println(v.toString()));
    }
    public void getVoterByUsername(String username) throws UnirestException{
        HttpResponse<Voter> response = Unirest.get(URL_VOTER + username).asObject(Voter.class);
        Voter voter = response.getBody();
        System.out.println(voter.toString());    
    }
    public void getUpDownVotesByUsername(String username) throws UnirestException{
        HttpResponse<UpDownVote> response = Unirest.get(URL_VOTES + username).asObject(UpDownVote.class);
        UpDownVote upDownVote = response.getBody();
        System.out.println(upDownVote.toString());
    }
}
