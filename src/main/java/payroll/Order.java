package payroll;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_ORDER")
class Order {

    @Id
    @GeneratedValue
    private long id;

    private String description;
    private OrderStatus status;

    public Order(String description, OrderStatus status) {
        this.description = description;
        this.status = status;
    }
}
