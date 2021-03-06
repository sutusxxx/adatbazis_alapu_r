package szte.adatb.allaskereses.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class JobSeeker {
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
    private Map<String, String> applications;

    public JobSeeker(int id, String username, String password, String name, String education, Date dateOfBirth, String language, String email, String address, String phone) {
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
