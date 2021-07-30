package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String workplace;
    private String city;

    public User(String firstName, String lastName, int age, String workplace, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workplace = workplace;
        this.city = city;
    }
}
