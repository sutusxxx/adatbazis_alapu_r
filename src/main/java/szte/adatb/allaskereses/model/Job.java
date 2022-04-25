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
public class Job {
    private int id;
    private String name;
    private String description;
    private int advertiserId;
    private String place;
}
