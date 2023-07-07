package bejeweled.server.clients;

import bejeweled.entity.Rating;
import bejeweled.service.RatingException;
import bejeweled.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RatingServiceRestClient implements RatingService {

    private final String url = "http://localhost:8080/api/rating";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void setRating(Rating rating) throws RatingException {
        restTemplate.postForEntity(url, rating, Rating.class);
    }

    @Override
    public List<Rating> getRatingGame(String game) throws RatingException {
        return Arrays.asList(Objects.requireNonNull(
                restTemplate.getForEntity(url + "/" + game, Rating[].class).getBody()
        ));
    }

    @Override
    public int getAverageRating(String game) throws RatingException {
        ResponseEntity<Integer> response = restTemplate.getForEntity(url + "/avg/" + game, Integer.class);
        if (response.getBody() != null) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public int getCountRating(String game) throws RatingException {
        ResponseEntity<Integer> response = restTemplate.getForEntity(url + "/count/" + game, Integer.class);
        if (response.getBody() != null) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        ResponseEntity<Integer> response = restTemplate.getForEntity(url + "/" + game, Integer.class);
        if (response.getBody() != null) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public void reset() throws RatingException {
        throw new UnsupportedOperationException("Not supported via web service");
    }
}
