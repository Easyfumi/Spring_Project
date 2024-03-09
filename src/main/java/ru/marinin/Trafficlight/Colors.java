package ru.marinin.Trafficlight;

public enum Colors implements Color{

    GREEN("зеленый"), RED("красный"), YELLOW1("желтый"), YELLOW2("желтый");
    static {
        GREEN.next = YELLOW1;
        YELLOW1.next = RED;
        RED.next = YELLOW2;
        YELLOW2.next = GREEN;
    }

    public  String name;
    public  Colors next;


    private Colors(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public Colors next() {
        return next;
    }
}
