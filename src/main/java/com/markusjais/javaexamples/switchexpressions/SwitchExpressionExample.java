package com.markusjais.javaexamples.switchexpressions;

enum Planet {
    EARTH,
    VENUS,
    MARS,
    SATURN
}

enum City {
    MADRID,
    PARIS,
    OSLO,
    ROME
}

public class SwitchExpressionExample {
    public static void main(String[] args) {

        Planet planet = Planet.EARTH;
        int numCharectersOfPlanet = switch (planet) {
            case MARS -> 4;
            case EARTH, VENUS -> 5;
            case SATURN -> 6;
        };
        System.out.printf("%s has %d characters\n", planet, numCharectersOfPlanet);

        City city = City.MADRID;
        int numCharactersOfCity = switch (city) {
            case MADRID -> {
                System.out.println("city has 6 characters");
                yield 6;
            }
            case PARIS -> {
                System.out.println("city has 5 characters");
                yield 5;
            }
            case ROME, OSLO -> {
                System.out.println("city has 4 characters");
                yield 4;
            }
        };
        System.out.printf("%s has %s characters\n", city, numCharactersOfCity);


    }
}
