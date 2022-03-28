package szte.adatb.allaskereses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return this.username;
    }
}
