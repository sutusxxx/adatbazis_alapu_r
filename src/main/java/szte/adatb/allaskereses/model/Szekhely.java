package szte.adatb.allaskereses.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Szekhely {
    private int id;
    private String megye;
    private String varos;
    private String utca;
    private int hazszam;
    private int irsz;

    @Override
    public String toString() {
        return this.megye+ " | " + this.varos;
    }
}
