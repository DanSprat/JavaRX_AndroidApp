package ru.popov.moviedbapiapplication;

import androidx.annotation.NonNull;

public class Movie {
    int id;
    String original_title;
    String overview;
    double vote_average;

    @NonNull
    @Override
    public String toString() {
        return String.format("Id: %d, Title: %s , Rate: %f",id,original_title,vote_average);
    }
}
