package ru.marinin.Trafficlight.Colors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.marinin.Trafficlight.Color;

@Component
@Qualifier("starter")
public class Green implements Color {
    @Autowired @Qualifier("yellowGreen")
    Color color;

    @Override
    public Color next() {
        return color;
    }

    @Override
    public String toString() {
        return "green";
    }
}
