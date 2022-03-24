package szte.adatb.allaskereses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Allaskereso {
    private int id;
    private String username;
    private String password;
    private String name;
    private String education;
    private Date dateOfBirht;
    private String language;
    private String email;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return this.username + " | " + this.name;
    }
}
