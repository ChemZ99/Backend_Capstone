package Personal.Capstone.Controllers;

import Personal.Capstone.Entities.Hotel;
import Personal.Capstone.Entities.Review;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Payloads_DTOs.NewHotelDTO;
import Personal.Capstone.Payloads_DTOs.NewReviewDTO;
import Personal.Capstone.Services.HotelService;
import Personal.Capstone.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    public ReviewService reviewService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Page<Review> getAllReviews(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return reviewService.getAllReviews(page, size);
    }

    @GetMapping("/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Review findReviewById(@PathVariable long id) {
        return reviewService.findReviewById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Review saveReview(@RequestBody @Validated NewReviewDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return reviewService.saveReview(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PutMapping("/modify/id={id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Review findReviewByIdAndUpdate(@PathVariable long id, @RequestBody Review body) {
        return reviewService.findReviewByIdAndUpdate(id, body);
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    void findReviewByIdAndDelete(@PathVariable long id) {
        reviewService.findReviewByIdAndDelete(id);
    }
}
