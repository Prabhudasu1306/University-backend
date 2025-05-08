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

    private String branch;

    private  String roomNo;

    private String address;


}
