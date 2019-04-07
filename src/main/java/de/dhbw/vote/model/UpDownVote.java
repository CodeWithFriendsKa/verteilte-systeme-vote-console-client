package de.dhbw.vote.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;

/***
 * Entityklasse, welche alle nötigen Attirbute für ein Voting enthält
 * 
 * Trippleprogramming
 * @author Rouven Brost
 * @author Christopher Pschibila
 * @author codekeks (Tamino Fischer)
 */
@JsonDeserialize(using = UpDownVoteDeserializer.class)
public class UpDownVote {

    private Long id;
    private String description;
    private String creator;
    private List<String> upVotes;
    private Integer upSize;
    private List<String> downVotes;
    private Integer downSize;
    private String date;
    private Category category;

    public UpDownVote(Long id, String description, String creator, List<String> upVotes, Integer upSize, List<String> downVotes, Integer downSize, String date, Category category) {
        this.id = id;
        this.description = description;
        this.creator = creator;
        this.upVotes = upVotes;
        this.upSize = upSize;
        this.downVotes = downVotes;
        this.downSize = downSize;
        this.date = date;
        this.category = category;
    }

    public UpDownVote() {
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(List<String> upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getUpSize() {
        return upSize;
    }

    public void setUpSize(Integer upSize) {
        this.upSize = upSize;
    }

    public List<String> getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(List<String> downVotes) {
        this.downVotes = downVotes;
    }

    public Integer getDownSize() {
        return downSize;
    }

    public void setDownSize(Integer downSize) {
        this.downSize = downSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UpDownVote{" + "id=" + id + ", description=" + description + ", creator=" + creator + ", upVotes=" + upVotes + ", upSize=" + upSize + ", downVotes=" + downVotes + ", downSize=" + downSize + ", date=" + date + ", category=" + category + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.creator);
        hash = 13 * hash + Objects.hashCode(this.upVotes);
        hash = 13 * hash + Objects.hashCode(this.upSize);
        hash = 13 * hash + Objects.hashCode(this.downVotes);
        hash = 13 * hash + Objects.hashCode(this.downSize);
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.category);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UpDownVote other = (UpDownVote) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.creator, other.creator)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.upVotes, other.upVotes)) {
            return false;
        }
        if (!Objects.equals(this.upSize, other.upSize)) {
            return false;
        }
        if (!Objects.equals(this.downVotes, other.downVotes)) {
            return false;
        }
        if (!Objects.equals(this.downSize, other.downSize)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }
    
    

}
