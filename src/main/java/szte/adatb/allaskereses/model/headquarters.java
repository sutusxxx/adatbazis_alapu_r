package szte.adatb.allaskereses.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class headquarters {
    private int id;
    private String county;
    private String city;
    private String street;
    private int houseNumber;
    private int zipCode;

    @Override
    public String toString() {
        return this.county + " | " + this.city;
    }
}
