package backend.Orders;

import backend.Domain.Order;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Infrastructure.ErrorMessages;
import backend.Orders.Models.OrderDetails;
import backend.Orders.Requests.CreateOrderRequest;
import backend.Orders.Requests.GetAllOrdersRequest;
import backend.Orders.Requests.HonorOrderRequest;
import backend.Repositories.MedicineRepository;
import backend.Repositories.OrderRepository;
import backend.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService extends AbstractService {
    private OrderRepository orderRepository;
    private MedicineRepository medicineRepository;
    private UserRepository userRepository;

    public List<OrderDetails> handle(GetAllOrdersRequest request) {
        return OrderDetails.FromOrder(orderRepository.findBySection(request.getSectionId()));
    }

    public void handle(CreateOrderRequest request) {
        var user = userRepository.findById(request.getUsername());
        if(user.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }
        var medicine = medicineRepository.findById(request.getMedicineId());
        if(medicine.isEmpty()){
            throw new IllegalStateException(ErrorMessages.MedicineNotFound);
        }

        Order order = new Order(user.get(), request.getQuantity(), medicine.get());

        orderRepository.save(order);
    }

    public void handle(HonorOrderRequest request) {
        var order = orderRepository.findById(request.getOrderId());
        if(order.isEmpty()){
            throw new IllegalStateException(ErrorMessages.OrderNotFound);
        }

        order.get().setIsActive(false);

        orderRepository.save(order.get());
    }
}
