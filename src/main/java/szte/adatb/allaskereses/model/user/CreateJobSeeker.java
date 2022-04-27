package szte.adatb.allaskereses.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobSeeker {
    private String username;
    private String password;
    private String name;
    private String education;
    private Date dateOfBirth;
    private String language;
    private String email;
    private String address;
    private String phone;
}
