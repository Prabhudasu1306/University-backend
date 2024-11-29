package University_backend.University.Entity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Data
@Table(name = "NonTeaching ")
public class NonTeaching {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String designation;
    private String department;
    private Double salary;
    private String contactNumber;
    private int experience;
}
