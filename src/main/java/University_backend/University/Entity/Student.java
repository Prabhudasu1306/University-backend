package University_backend.University.Entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String course;

    private String duration;

    private Long fee;
}
