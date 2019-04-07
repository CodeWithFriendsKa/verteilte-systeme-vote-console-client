package de.dhbw.vote.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

/**
 *
 * @author codekeks
 */
@JsonDeserialize(using = VoterDeserializer.class)
public class Voter {
    private String username;
    private String mail;
    private String prename;
    private String name;
    private int age;
    private Sex sex;    

    public Voter(String username, String mail, String prename, String name, int age, Sex sex) {
        this.username = username;
        this.mail = mail;
        this.prename = prename;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Voter{" + "username=" + username + ", mail=" + mail + ", prename=" + prename + ", name=" + name + ", age=" + age + ", sex=" + sex + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.mail);
        hash = 73 * hash + Objects.hashCode(this.prename);
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + this.age;
        hash = 73 * hash + Objects.hashCode(this.sex);
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
        final Voter other = (Voter) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.prename, other.prename)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        return true;
    }
    
    
}
