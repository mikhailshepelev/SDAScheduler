package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    private int trainerID;
    private String name;
    private boolean isMale;
    private int age;
    private String email;
    private String phoneNumber;
    private List<String> skills;

    @OneToMany(mappedBy = "trainer")
    private List<Topic> topicsList = new ArrayList<>();

    public Trainer(int trainerID, String name, boolean isMale, int age, String email, String phoneNumber, List<String> skills) {
        this.trainerID = trainerID;
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }

    public Trainer() {
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "tID=" + trainerID +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", skills=" + skills +
                '}';
    }
}
