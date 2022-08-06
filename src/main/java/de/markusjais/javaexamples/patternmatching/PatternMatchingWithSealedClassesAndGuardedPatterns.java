package de.markusjais.javaexamples.patternmatching;


abstract sealed class Bike permits GravelBike, MountainBike, RoadBike {
    public abstract int getNumberOfGears();
}
final class GravelBike extends Bike {
    @Override
    public int getNumberOfGears() {
        return 12;
    }
}
non-sealed class MountainBike extends Bike {
    @Override
    public int getNumberOfGears() {
        return 12;
    }
}
sealed class RoadBike extends Bike permits AeroBike, RaceBike {
    @Override
    public int getNumberOfGears() {
        return 24;
    }
}
final class AeroBike extends RoadBike {}
final class RaceBike extends RoadBike {}

class FullSuss extends MountainBike {}
class Hardtail extends MountainBike {}

public class PatternMatchingWithSealedClassesAndGuardedPatterns {

    public static void main(final String[] args) {
        print(new MountainBike());
        print(new RaceBike());
        print(new GravelBike());
    }

    private static void print(Bike bike) {
        String toPrint = switch (bike) {
            case RoadBike rb when rb.getNumberOfGears() < 24 -> "You're bike is outdated";
            case RoadBike roadBike -> "Don't hit old ladies with your road bike";
            case FullSuss mtb when mtb.getNumberOfGears() > 12 -> "You're a weird bloke";
            case MountainBike mountainBike -> "drive carefully";
            case GravelBike gravelBike -> "you're a modern rider";
        };
        System.out.println (toPrint);
    }
}


