package bejeweled.service;

import bejeweled.entity.Rating;

import java.util.List;

public interface RatingService {
    void setRating(Rating rating) throws RatingException;
    List<Rating> getRatingGame(String game) throws RatingException;
    int getAverageRating(String game) throws RatingException;
    int getCountRating(String game) throws RatingException;
    int getRating(String game, String player) throws RatingException;
    void reset() throws RatingException;
}
