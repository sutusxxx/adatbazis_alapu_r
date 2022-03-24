package szte.adatb.allaskereses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import szte.adatb.allaskereses.model.Allaskereso;
import szte.adatb.allaskereses.repository.AllaskeresoRepository;

import javax.sql.DataSource;
import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
public class AllaskeresesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllaskeresesApplication.class, args);
    }
}
