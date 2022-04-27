package szte.adatb.allaskereses.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertiser {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
}
