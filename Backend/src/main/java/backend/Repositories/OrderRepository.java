package backend.Repositories;

import backend.Domain.Order;
import backend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(
            value = "SELECT o FROM Order o " +
                    "WHERE o.createdBy.section.id = ?1 " +
                    "AND o.isActive = true " +
                    "order by o.date asc"
    )
    List<Order> findBySection(int sectionId);
}
