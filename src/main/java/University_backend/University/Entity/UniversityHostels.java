package University_backend.University.Entity;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversityHostels {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String floor;

    private String roomNo;

    private String bedNo;
}
