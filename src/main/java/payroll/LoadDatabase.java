package payroll;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading : " + repository.save(new Employee("Batman", "Bruce", "Hero")));
            log.info("Preloading : " + repository.save(new Employee("Joker", "XXX", "Villan")));
            orderRepository.save(new Order("IPhone", OrderStatus.COMPLETED));
            orderRepository.save(new Order("OnePlus", OrderStatus.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
