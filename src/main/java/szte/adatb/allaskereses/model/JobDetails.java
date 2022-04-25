package szte.adatb.allaskereses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDetails {
    private int id;
    private String name;
    private String description;
    private String place;
    private String companyName;
    private String advertiserName;
    private String advertiserEmail;
    private String advertiserPhone;
    private List<String> workType;
}
