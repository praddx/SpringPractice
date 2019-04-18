package payroll;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler {

    Resource<Order> toResource(Order order) {
        Resource<Order> resource = new Resource<>(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if (order.getStatus() == OrderStatus.IN_PROGRESS) {
            resource.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
            resource.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
        }


        return resource;
    }
}
