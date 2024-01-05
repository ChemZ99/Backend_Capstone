package Personal.Capstone.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Column
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Hotel> hotels;

    public City(String name, String province, String state, long population, List<Hotel> hotels) {
        this.name = name;
        this.province = province;
        this.state = state;
        this.population = population;
        this.hotels = hotels;
    }
}
