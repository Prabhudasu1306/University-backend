package University_backend.University.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    private String phoneNumber;

    private String email;

    private String address;

    private String website;

    private String deanName;

    private int establishedYear;

    private String description;

    @Lob
    private String logo;

    @Column(nullable = false)
    private Boolean isActive;
}
