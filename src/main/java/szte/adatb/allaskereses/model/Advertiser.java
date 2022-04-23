package szte.adatb.allaskereses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advertiser {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private int companyId;
}
