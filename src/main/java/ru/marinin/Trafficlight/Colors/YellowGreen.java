package ru.marinin.Trafficlight.Colors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.marinin.Trafficlight.Color;

@Component
public class YellowGreen implements Color {
    @Autowired @Qualifier("red")
    Color color;
    @Override
    public Color next() {
        return color;
    }
    @Override
    public String toString() {
        return "yellow";
    }
}
