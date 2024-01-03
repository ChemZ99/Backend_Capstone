package Personal.Capstone.Services;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Entities.Review;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Exceptions.NotFoundException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Payloads_DTOs.NewReviewDTO;
import Personal.Capstone.Repositories.HotelRepository;
import Personal.Capstone.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private UserService userService;

    public Review saveReview(NewReviewDTO reviewDTO) throws IOException {

        Review newReview = new Review();
        newReview.setEvaluation(reviewDTO.evaluation());
        newReview.setDescription(reviewDTO.description());
        newReview.setDate_of_dispatch(reviewDTO.date_of_dispatch());
        newReview.setUser(userService.findUserById(reviewDTO.userid()));
        newReview.setHotel(hotelService.findHotelById(reviewDTO.hotelid()));
        return reviewRepo.save(newReview);
    }

    public Review findReviewById(long id) throws NotFoundException {
        return reviewRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Page<Review> getAllReviews(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepo.findAll(pageable);
    }

    public Review findReviewByIdAndUpdate(long id, Review body) throws NotFoundException {
        Review target = this.findReviewById(id);
        target.setEvaluation(body.getEvaluation());
        target.setDescription(body.getDescription());
        target.setDate_of_dispatch(body.getDate_of_dispatch());
        target.setUser(body.getUser());
        target.setHotel(body.getHotel());
        return reviewRepo.save(target);
    }


    public void findReviewByIdAndDelete(long id) throws NotFoundException {
        Review foundReview = this.findReviewById(id);
        reviewRepo.delete(foundReview);
    }
}
