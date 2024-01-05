package Personal.Capstone.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Review(double evaluation, String description, LocalDate date_of_dispatch, User user) {
        this.evaluation = evaluation;
        this.description = description;
        this.date_of_dispatch = date_of_dispatch;
        this.user = user;
    }
}
