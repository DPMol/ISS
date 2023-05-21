package backend.Orders.Models;

import backend.Domain.Medicine;
import backend.Domain.Order;
import backend.Domain.User;
import backend.Medicines.Models.MedicineDetails;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDetails {
    private int id;
    private User createdBy;
    private LocalDateTime date;
    private int quantity;
    private Medicine medicine;
    private Boolean isActive;

    public static OrderDetails FromOrder(Order order){
        return new OrderDetails(order.getId(), order.getCreatedBy(), order.getDate(), order.getQuantity(), order.getMedicine(), order.getIsActive());
    }

    public static List<OrderDetails> FromOrder(List<Order> orders){
        return orders.stream().map(OrderDetails::FromOrder).toList();
    }
}
