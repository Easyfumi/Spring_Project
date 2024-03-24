package ru.marinin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class RewiewsService {
//    @Bean
//    Reviews get2() {
//        Reviews review = new Reviews(TextForReviews.BAD);
//        return review;
//    }

    Reviews get3() {
        Reviews review = new Reviews(TextForReviews.NORM);
        return review;
    }

    Reviews get4() {
        Reviews review = new Reviews(TextForReviews.GOOD);
        return review;
    }
//    @Bean
//    Reviews get5() {
//        Reviews review = new Reviews(TextForReviews.EXCELLENT);
//        return review;
//    }

    Reviews getWTF() {
        Reviews review = new Reviews(TextForReviews.WTF);
        return review;
    }
}
