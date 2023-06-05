package backend.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "Medicines"
)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Medicine {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    public Medicine(String name){
        this.name = name;
    }
}
