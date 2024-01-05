package Personal.Capstone;

import Personal.Capstone.Entities.*;
import Personal.Capstone.Repositories.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

	// database populator decommentare solo per il primo avvio



	@Resource
	private ReviewRepository reviewRepo;
	@Resource
	private CityRepository cityRepo;
	@Resource
	private HotelRepository hotelRepo;
	@Resource
	private ReservationRepository reservationRepo;
	@Resource
	private UserRepository userRepo;
	@Autowired
	PasswordEncoder bcrypt;

	@Bean
	public CommandLineRunner populateDatabase() {
		return new DatabasePopulatorRunner();
	}

public class DatabasePopulatorRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {

		//liste reviews, reservations e hotels

		List<Review> exampleReviews1 = new ArrayList<>();
		List<Reservation> exampleReservations1 = new ArrayList<>();
		List<Review> exampleReviews2 = new ArrayList<>();
		List<Reservation> exampleReservations2 = new ArrayList<>();
		List<Review> exampleReviews3 = new ArrayList<>();
		List<Reservation> exampleReservations3 = new ArrayList<>();
		List<Review> exampleReviews4 = new ArrayList<>();
		List<Reservation> exampleReservations4 = new ArrayList<>();
		List<Review> exampleReviews5 = new ArrayList<>();
		List<Reservation> exampleReservations5 = new ArrayList<>();
		List<Hotel> hotelsFirenze = new ArrayList<>();
		List<Hotel> hotelsMilano = new ArrayList<>();
		List<Hotel> hotelsBologna = new ArrayList<>();

		// users

		User admin = new User("Chemz","astarore@gmail.com",bcrypt.encode("1234"),"Andrea","Cavallo",Role.ADMIN,"https://ui-avatars.com/api/?name=Andrea+Cavallo");
		User user = new User("Zaster","Zaster@gmail.com",bcrypt.encode("1234"),"John","Doe",Role.USER,"https://ui-avatars.com/api/?name=John+Doe");

		// reviews

		Review exampleReview1 = new Review( 4, "nice and cozy place", LocalDate.of(2020,2,12),user);
		Review exampleReview2 = new Review( 1, "awful", LocalDate.of(2015,6,16),user);
		Review exampleReview3 = new Review( 5, "perfect", LocalDate.of(2022,11,3),user);
		Review exampleReview4 = new Review( 4, "good food", LocalDate.of(2011,1,11),user);
		Review exampleReview5 = new Review( 3, "average", LocalDate.of(2011,1,11),user);
		Review exampleReview6 = new Review( 4, "nice and cozy place", LocalDate.of(2020,2,12),user);
		Review exampleReview7 = new Review( 1, "awful", LocalDate.of(2015,6,16),user);
		Review exampleReview8 = new Review( 5, "perfect", LocalDate.of(2022,11,3),user);
		Review exampleReview9 = new Review( 4, "good food", LocalDate.of(2011,1,11),user);
		Review exampleReview10 = new Review( 3, "average", LocalDate.of(2011,1,11),user);
		Review exampleReview11 = new Review( 4, "nice and cozy place", LocalDate.of(2020,2,12),user);
		Review exampleReview12 = new Review( 1, "awful", LocalDate.of(2015,6,16),user);
		Review exampleReview13 = new Review( 5, "perfect", LocalDate.of(2022,11,3),user);
		Review exampleReview14 = new Review( 4, "good food", LocalDate.of(2011,1,11),user);
		Review exampleReview15 = new Review( 3, "average", LocalDate.of(2011,1,11),user);
		Review exampleReview16 = new Review( 4, "nice and cozy place", LocalDate.of(2020,2,12),user);
		Review exampleReview17 = new Review( 1, "awful", LocalDate.of(2015,6,16),user);
		Review exampleReview18 = new Review( 5, "perfect", LocalDate.of(2022,11,3),user);
		Review exampleReview19 = new Review( 4, "good food", LocalDate.of(2011,1,11),user);
		Review exampleReview20 = new Review( 3, "average", LocalDate.of(2011,1,11),user);
		Review exampleReview21 = new Review( 4, "nice and cozy place", LocalDate.of(2020,2,12),user);
		Review exampleReview22 = new Review( 1, "awful", LocalDate.of(2015,6,16),user);
		Review exampleReview23 = new Review( 5, "perfect", LocalDate.of(2022,11,3),user);
		Review exampleReview24 = new Review( 4, "good food", LocalDate.of(2011,1,11),user);
		Review exampleReview25 = new Review( 3, "average", LocalDate.of(2011,1,11),user);
		exampleReviews1.add(exampleReview1);
		exampleReviews1.add(exampleReview2);
		exampleReviews1.add(exampleReview3);
		exampleReviews1.add(exampleReview4);
		exampleReviews1.add(exampleReview5);
		exampleReviews2.add(exampleReview6);
		exampleReviews2.add(exampleReview7);
		exampleReviews2.add(exampleReview8);
		exampleReviews2.add(exampleReview9);
		exampleReviews2.add(exampleReview10);
		exampleReviews3.add(exampleReview11);
		exampleReviews3.add(exampleReview12);
		exampleReviews3.add(exampleReview13);
		exampleReviews3.add(exampleReview14);
		exampleReviews3.add(exampleReview15);
		exampleReviews4.add(exampleReview16);
		exampleReviews4.add(exampleReview17);
		exampleReviews4.add(exampleReview18);
		exampleReviews4.add(exampleReview19);
		exampleReviews4.add(exampleReview20);
		exampleReviews5.add(exampleReview21);
		exampleReviews5.add(exampleReview22);
		exampleReviews5.add(exampleReview23);
		exampleReviews5.add(exampleReview24);
		exampleReviews5.add(exampleReview25);

		// reservations

		Reservation exampleReservation1 = new Reservation(LocalDate.of(2023,10,10),LocalDate.of(2023,10,17),Reservation_Type.NORMAL,85,user);
		Reservation exampleReservation2 = new Reservation(LocalDate.of(2023,9,15),LocalDate.of(2023,9,22),Reservation_Type.NORMAL,60,user);
		Reservation exampleReservation3 = new Reservation(LocalDate.of(2023,8,2),LocalDate.of(2023,8,9),Reservation_Type.NORMAL,70,user);
		Reservation exampleReservation4 = new Reservation(LocalDate.of(2023,7,11),LocalDate.of(2023,10,18),Reservation_Type.NORMAL,90,user);
		Reservation exampleReservation5 = new Reservation(LocalDate.of(2023,6,22),LocalDate.of(2023,6,29),Reservation_Type.NORMAL,110,user);
		Reservation exampleReservation6 = new Reservation(LocalDate.of(2023,10,10),LocalDate.of(2023,10,17),Reservation_Type.NORMAL,85,user);
		Reservation exampleReservation7 = new Reservation(LocalDate.of(2023,9,15),LocalDate.of(2023,9,22),Reservation_Type.NORMAL,60,user);
		Reservation exampleReservation8 = new Reservation(LocalDate.of(2023,8,2),LocalDate.of(2023,8,9),Reservation_Type.NORMAL,70,user);
		Reservation exampleReservation9 = new Reservation(LocalDate.of(2023,7,11),LocalDate.of(2023,10,18),Reservation_Type.NORMAL,90,user);
		Reservation exampleReservation10 = new Reservation(LocalDate.of(2023,6,22),LocalDate.of(2023,6,29),Reservation_Type.NORMAL,110,user);
		Reservation exampleReservation11 = new Reservation(LocalDate.of(2023,10,10),LocalDate.of(2023,10,17),Reservation_Type.NORMAL,85,user);
		Reservation exampleReservation12 = new Reservation(LocalDate.of(2023,9,15),LocalDate.of(2023,9,22),Reservation_Type.NORMAL,60,user);
		Reservation exampleReservation13 = new Reservation(LocalDate.of(2023,8,2),LocalDate.of(2023,8,9),Reservation_Type.NORMAL,70,user);
		Reservation exampleReservation14 = new Reservation(LocalDate.of(2023,7,11),LocalDate.of(2023,10,18),Reservation_Type.NORMAL,90,user);
		Reservation exampleReservation15 = new Reservation(LocalDate.of(2023,6,22),LocalDate.of(2023,6,29),Reservation_Type.NORMAL,110,user);
		Reservation exampleReservation16 = new Reservation(LocalDate.of(2023,10,10),LocalDate.of(2023,10,17),Reservation_Type.NORMAL,85,user);
		Reservation exampleReservation17 = new Reservation(LocalDate.of(2023,9,15),LocalDate.of(2023,9,22),Reservation_Type.NORMAL,60,user);
		Reservation exampleReservation18 = new Reservation(LocalDate.of(2023,8,2),LocalDate.of(2023,8,9),Reservation_Type.NORMAL,70,user);
		Reservation exampleReservation19 = new Reservation(LocalDate.of(2023,7,11),LocalDate.of(2023,10,18),Reservation_Type.NORMAL,90,user);
		Reservation exampleReservation20 = new Reservation(LocalDate.of(2023,6,22),LocalDate.of(2023,6,29),Reservation_Type.NORMAL,110,user);
		Reservation exampleReservation21 = new Reservation(LocalDate.of(2023,10,10),LocalDate.of(2023,10,17),Reservation_Type.NORMAL,85,user);
		Reservation exampleReservation22 = new Reservation(LocalDate.of(2023,9,15),LocalDate.of(2023,9,22),Reservation_Type.NORMAL,60,user);
		Reservation exampleReservation23 = new Reservation(LocalDate.of(2023,8,2),LocalDate.of(2023,8,9),Reservation_Type.NORMAL,70,user);
		Reservation exampleReservation24 = new Reservation(LocalDate.of(2023,7,11),LocalDate.of(2023,10,18),Reservation_Type.NORMAL,90,user);
		Reservation exampleReservation25 = new Reservation(LocalDate.of(2023,6,22),LocalDate.of(2023,6,29),Reservation_Type.NORMAL,110,user);
		exampleReservations1.add(exampleReservation1);
		exampleReservations1.add(exampleReservation2);
		exampleReservations1.add(exampleReservation3);
		exampleReservations1.add(exampleReservation4);
		exampleReservations1.add(exampleReservation5);
		exampleReservations2.add(exampleReservation6);
		exampleReservations2.add(exampleReservation7);
		exampleReservations2.add(exampleReservation8);
		exampleReservations2.add(exampleReservation9);
		exampleReservations2.add(exampleReservation10);
		exampleReservations3.add(exampleReservation11);
		exampleReservations3.add(exampleReservation12);
		exampleReservations3.add(exampleReservation13);
		exampleReservations3.add(exampleReservation14);
		exampleReservations3.add(exampleReservation15);
		exampleReservations4.add(exampleReservation16);
		exampleReservations4.add(exampleReservation17);
		exampleReservations4.add(exampleReservation18);
		exampleReservations4.add(exampleReservation19);
		exampleReservations4.add(exampleReservation20);
		exampleReservations5.add(exampleReservation21);
		exampleReservations5.add(exampleReservation22);
		exampleReservations5.add(exampleReservation23);
		exampleReservations5.add(exampleReservation24);
		exampleReservations5.add(exampleReservation25);

		// cities

		City firenze = new City("Firenze","Toscana","Italia",300000,hotelsFirenze);
		City milano = new City("Milano","Lombardia","Italia",550000,hotelsMilano);
		City bologna = new City("Bologna","Emilia Romagna","Italia",400000,hotelsBologna);

		//hotels

		Hotel hotel1Firenze = new Hotel("Continental-Firenze",5,Hotel_Type.HOTEL,true,true,true,true,"www.continental.com",firenze,exampleReviews1,exampleReservations1);
		Hotel hotel2Firenze = new Hotel("Atlantic-Firenze",4,Hotel_Type.RESORT,true,true,true,false,"www.atlantic.com",firenze,exampleReviews2,exampleReservations2);
		Hotel hotel3Firenze = new Hotel("Alba-Firenze",2,Hotel_Type.BED_BREAKFAST,true,true,false,false,"www.alba.com",firenze,exampleReviews3,exampleReservations3);
		Hotel hotel4Firenze = new Hotel("Last Resort-Firenze",3,Hotel_Type.HOSTEL,true,false,false,true,"www.LastResort.com",firenze,exampleReviews4,exampleReservations4);
		Hotel hotel5Firenze = new Hotel("Hawkeye-Firenze",1,Hotel_Type.MOTEL,false,false,false,true,"none",firenze,exampleReviews5,exampleReservations5);
		Hotel hotel1Milano = new Hotel("Continental-Milano",5,Hotel_Type.HOTEL,true,true,true,true,"www.continental.com",milano,exampleReviews1,exampleReservations1);
		Hotel hotel2Milano = new Hotel("Atlantic-Milano",4,Hotel_Type.RESORT,true,true,true,false,"www.atlantic.com",milano,exampleReviews2,exampleReservations2);
		Hotel hotel3Milano = new Hotel("Alba-Milano",2,Hotel_Type.BED_BREAKFAST,true,true,false,false,"www.alba.com",milano,exampleReviews3,exampleReservations3);
		Hotel hotel4Milano = new Hotel("Last Resort-Milano",3,Hotel_Type.HOSTEL,true,false,false,true,"www.LastResort.com",milano,exampleReviews4,exampleReservations4);
		Hotel hotel5Milano = new Hotel("Hawkeye-Milano",1,Hotel_Type.MOTEL,false,false,false,true,"none",milano,exampleReviews5,exampleReservations5);
		Hotel hotel1Bologna = new Hotel("Continental-Bologna",5,Hotel_Type.HOTEL,true,true,true,true,"www.continental.com",bologna,exampleReviews1,exampleReservations1);
		Hotel hotel2Bologna = new Hotel("Atlantic-Bologna",4,Hotel_Type.RESORT,true,true,true,false,"www.atlantic.com",bologna,exampleReviews2,exampleReservations2);
		Hotel hotel3Bologna = new Hotel("Alba-Bologna",2,Hotel_Type.BED_BREAKFAST,true,true,false,false,"www.alba.com",bologna,exampleReviews3,exampleReservations3);
		Hotel hotel4Bologna = new Hotel("Last Resort-Bologna",3,Hotel_Type.HOSTEL,true,false,false,true,"www.LastResort.com",bologna,exampleReviews4,exampleReservations4);
		Hotel hotel5Bologna = new Hotel("Hawkeye-Bologna",1,Hotel_Type.MOTEL,false,false,false,true,"none",bologna,exampleReviews5,exampleReservations5);

		hotelsFirenze.add(hotel1Firenze);
		hotelsFirenze.add(hotel2Firenze);
		hotelsFirenze.add(hotel3Firenze);
		hotelsFirenze.add(hotel4Firenze);
		hotelsFirenze.add(hotel5Firenze);
		hotelsMilano.add(hotel1Milano);
		hotelsMilano.add(hotel2Milano);
		hotelsMilano.add(hotel3Milano);
		hotelsMilano.add(hotel4Milano);
		hotelsMilano.add(hotel5Milano);
		hotelsBologna.add(hotel1Bologna);
		hotelsBologna.add(hotel2Bologna);
		hotelsBologna.add(hotel3Bologna);
		hotelsBologna.add(hotel4Bologna);
		hotelsBologna.add(hotel5Bologna);

		// DB save

		userRepo.save(user);
		userRepo.save(admin);
		cityRepo.save(firenze);
		/*cityRepo.save(milano);
		cityRepo.save(bologna);
		hotelRepo.save(hotel1Firenze);
		hotelRepo.save(hotel2Firenze);
		hotelRepo.save(hotel3Firenze);
		hotelRepo.save(hotel4Firenze);
		hotelRepo.save(hotel5Firenze);
		hotelRepo.save(hotel1Milano);
		hotelRepo.save(hotel2Milano);
		hotelRepo.save(hotel3Milano);
		hotelRepo.save(hotel4Milano);
		hotelRepo.save(hotel5Milano);
		hotelRepo.save(hotel1Bologna);
		hotelRepo.save(hotel2Bologna);
		hotelRepo.save(hotel3Bologna);
		hotelRepo.save(hotel4Bologna);
		hotelRepo.save(hotel5Bologna);
		reservationRepo.save(exampleReservation1);
		reservationRepo.save(exampleReservation2);
		reservationRepo.save(exampleReservation3);
		reservationRepo.save(exampleReservation4);
		reservationRepo.save(exampleReservation5);
		reservationRepo.save(exampleReservation6);
		reservationRepo.save(exampleReservation7);
		reservationRepo.save(exampleReservation8);
		reservationRepo.save(exampleReservation9);
		reservationRepo.save(exampleReservation10);
		reservationRepo.save(exampleReservation11);
		reservationRepo.save(exampleReservation12);
		reservationRepo.save(exampleReservation13);
		reservationRepo.save(exampleReservation14);
		reservationRepo.save(exampleReservation15);
		reservationRepo.save(exampleReservation16);
		reservationRepo.save(exampleReservation17);
		reservationRepo.save(exampleReservation18);
		reservationRepo.save(exampleReservation19);
		reservationRepo.save(exampleReservation20);
		reservationRepo.save(exampleReservation21);
		reservationRepo.save(exampleReservation22);
		reservationRepo.save(exampleReservation23);
		reservationRepo.save(exampleReservation24);
		reservationRepo.save(exampleReservation25);*/
	}}
}


