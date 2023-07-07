package bejeweled.server.webservice;


import bejeweled.entity.Rating;
import bejeweled.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingServiceRest {

    private final RatingService ratingService;

    public RatingServiceRest(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public void addRating(@RequestBody Rating rating)
    {
        ratingService.setRating(rating);
    }

    @GetMapping("/avg/{game}")
    public int getAverageRating(@PathVariable String game)
    {
       return ratingService.getAverageRating(game);
    }

    @GetMapping("/count/{game}")
    int getCountRating(@PathVariable String game)
    {
        return ratingService.getCountRating(game);
    }

    @GetMapping("/{game}")
    List<Rating> getRatingGame(@PathVariable String game)
    {
        return ratingService.getRatingGame(game);
    }

}
