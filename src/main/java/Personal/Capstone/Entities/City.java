package Personal.Capstone.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private long cityId;
    @Column
    private String name;
    @Column
    private String province;
    @Column
    private String state;
    @Column
    private long population;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;
}
