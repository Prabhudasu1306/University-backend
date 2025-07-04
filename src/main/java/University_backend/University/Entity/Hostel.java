package University_backend.University.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hostels")
@Getter
@Setter
@Entity
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String floor;

    private String roomNo;

    private String bedNo;

    private String branch;

    private String address;


}
