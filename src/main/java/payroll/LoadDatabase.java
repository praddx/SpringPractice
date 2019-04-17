package payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading : " + repository.save(new Employee("Batman", "Bruce", "Hero")));
            log.info("Preloading : " + repository.save(new Employee("Joker", "XXX", "Villan")));
        };
    }
}
