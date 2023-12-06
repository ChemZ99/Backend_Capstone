package Personal.Capstone.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private long hotelId;
    @Column
    private String name;
    @Column
    private int stars;
    @Column
    @Enumerated(EnumType.STRING)
    private Hotel_Type hotelType;
    @Column
    private boolean wifi;
    @Column
    private boolean breakfast;
    @Column
    private boolean pool;
    @Column
    private boolean parking;
    @Column
    private String websiteURL;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<Review> reviews;
    @OneToMany(mappedBy = "hotel")
    private List<Reservation> reservations;

}
