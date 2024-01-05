package Personal.Capstone.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private long reservationId;
    @Column
    private LocalDate reservation_start;
    @Column
    private LocalDate reservation_end;
    @Column
    @Enumerated(EnumType.STRING)
    private Reservation_Type reservation_type;
    @Column
    private int price_per_day;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation(LocalDate reservation_start, LocalDate reservation_end, Reservation_Type reservation_type, int price_per_day, User user) {
        this.reservation_start = reservation_start;
        this.reservation_end = reservation_end;
        this.reservation_type = reservation_type;
        this.price_per_day = price_per_day;
        this.user = user;
    }
}
