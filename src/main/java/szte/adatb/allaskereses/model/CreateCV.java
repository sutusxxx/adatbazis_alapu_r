package szte.adatb.allaskereses.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCV {
    private String introduction;
    private String experience;
    private String motivation;
    private int jobSeekerId;
}
