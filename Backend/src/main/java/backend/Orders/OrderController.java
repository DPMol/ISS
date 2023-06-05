package backend.Orders;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Orders.Models.OrderDetails;
import backend.Orders.Requests.CreateOrderRequest;
import backend.Orders.Requests.GetAllOrdersRequest;
import backend.Orders.Requests.HonorOrderRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController extends AbstractController {
    private OrderService orderService;

    @CrossOrigin
    @GetMapping("/getall")
    public List<OrderDetails> getAllOrders(@RequestParam(name = "sectionId") int id){
        return orderService.handle(new GetAllOrdersRequest(id));
    }

    @CrossOrigin
    @PostMapping("/create")
    public void createOrder(@Valid @RequestBody CreateOrderRequest request){
        orderService.handle(request);
    }

    @CrossOrigin
    @PostMapping("/honor")
    public void honorOrder(@Valid @RequestBody HonorOrderRequest request){
        orderService.handle(request);
    }
}
