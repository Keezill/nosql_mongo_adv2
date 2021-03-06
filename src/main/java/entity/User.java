package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String workplace;
    private String city;
    private List<String> accounts;

    public User(String firstName, String lastName, int age, String workplace, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workplace = workplace;
        this.city = city;
        this.id = UUID.randomUUID().toString();
    }
}
