package Personal.Capstone.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private City city;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Hotel(String name, int stars, Hotel_Type hotelType, boolean wifi, boolean breakfast, boolean pool, boolean parking, String websiteURL, City city, List<Review> reviews, List<Reservation> reservations) {
        this.name = name;
        this.stars = stars;
        this.hotelType = hotelType;
        this.wifi = wifi;
        this.breakfast = breakfast;
        this.pool = pool;
        this.parking = parking;
        this.websiteURL = websiteURL;
        this.city = city;
        this.reviews = reviews;
        this.reservations = reservations;
    }
}
