package backend.Orders;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Orders.Models.OrderDetails;
import backend.Orders.Requests.GetAllOrdersRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController extends AbstractController {
    private OrderService orderService;

    @GetMapping("/getall")
    public List<OrderDetails> getAllOrders(@Valid @RequestBody GetAllOrdersRequest request){
        return orderService.handle(request);
    }
}
