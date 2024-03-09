package ru.marinin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Reviews {
    TextForReviews text;

    public Reviews(TextForReviews text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
