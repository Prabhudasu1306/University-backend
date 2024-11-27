package University_backend.University.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "TeachingStaff")
public class TeachingStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private String designation;
    private LocalDate dateOfJoining;
    private String highestQualification;
    private int experience;
    private Long salary;



}
