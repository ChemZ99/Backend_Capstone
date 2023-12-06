package Personal.Capstone.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private long reviewId;
    @Column
    private double evaluation;
    @Column
    private String description;
    @Column
    private LocalDate date_of_dispatch;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
