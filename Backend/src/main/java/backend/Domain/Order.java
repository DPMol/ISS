package backend.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "Orders"
)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "createdBy", nullable = false)
    private User createdBy;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "medicineId", nullable = false)
    private Medicine medicine;
    @Column(name = "isActive")
    private Boolean isActive;
}
