package ru.marinin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public enum TextForReviews {
    BAD("Ужас, переделывай",2),
    NORM("Сойдет",3),
    GOOD("Хорошо",4),
    EXCELLENT("ОЧЕНЬ ХОРОШО!!!",5),
    WTF("Сложно сказать", (int) new AnnotationConfigApplicationContext("ru.marinin").getBean("randomInt"));
    public  String text;
    public int grade;
    private TextForReviews(String name, int grade) {
        this.text = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return text + ",оценка " + grade;
    }
}
