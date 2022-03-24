package szte.adatb.allaskereses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import szte.adatb.allaskereses.Model.Allaskereso;
import szte.adatb.allaskereses.Repository.AllaskeresoRepository;

import javax.sql.DataSource;
import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
public class AllaskeresesApplication implements CommandLineRunner {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    AllaskeresoRepository allaskeresoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AllaskeresesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
        System.out.println("Display all allaskereso");
        List<Allaskereso> list = allaskeresoRepository.findAll();
        list.forEach(ak -> System.out.println(ak));

        System.out.println("DONE");
        exit(0);
    }
}
