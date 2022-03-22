package de.markusjais.javaexamples.concurrency.futures;


import java.util.Set;

/* dummy class to simulate a database of eagle species

 the lookup methods sleep for a random number of milliseconds to simulate slow db queries

 note for the birders and eagle specialists. The weight and wingspan used is for female birds and
 in real life there is a huge variation in the weight (and less so in wingspan) of individual birds
 here we use a simple integer to keep it simple
 */
public class    EagleDatabase {

    private final Set<Eagle> birds = Set.of(
            new Eagle("Golden Eagle", 5000, 230),
            new Eagle("Harpy Eagle", 9000, 200),
            new Eagle("Booted Eagle", 1200, 130)
    );

    public EagleDatabase() {

    }

    public Eagle findEagleByName() {
        return null;

    }

    public Set<Eagle> findEaglesByWingspanLargerThan(int wingspanInCm) {
        return null;
    }



}
