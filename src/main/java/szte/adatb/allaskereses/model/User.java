package szte.adatb.allaskereses.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String education;
    private Date dateOfBirth;
    private String language;
    private String email;
    private String address;
    private String phone;
    private Set<Job> applications;

    public User(int id, String username, String password, String name, String education, Date dateOfBirth, String language, String email, String address, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.education = education;
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
