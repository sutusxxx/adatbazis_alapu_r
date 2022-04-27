package szte.adatb.allaskereses.model.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private int id;
    private String name;
    private String description;
    private int advertiserId;
    private String place;
}
