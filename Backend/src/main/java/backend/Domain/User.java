package backend.Domain;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@Table(
        name = "Users"
)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;
}
