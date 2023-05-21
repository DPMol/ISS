package backend.Orders;

import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Orders.Models.OrderDetails;
import backend.Orders.Requests.GetAllOrdersRequest;
import backend.Repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService extends AbstractService {
    private OrderRepository orderRepository;

    public List<OrderDetails> handle(GetAllOrdersRequest request) {
        return OrderDetails.FromOrder(orderRepository.findBySection(request.getSectionId()));
    }
}
