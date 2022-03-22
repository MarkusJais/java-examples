package de.markusjais.javaexamples.streams.sorting;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Cat(String name, int weightInKg){}

public class SortExample {

	static List<Cat> cats = List.of(
			new Cat("Puma", 70),
			new Cat("Leopard", 60),
			new Cat("Manul", 5),
			new Cat("Tiger", 220));

	public static void main(String[] args) {

		List<String> sortedBigCatsByWeight = cats.stream()
				.filter(c -> c.weightInKg() > 50)
				.sorted(Comparator.comparingInt(Cat::weightInKg).reversed())
				.map(c -> c.name() + " (" + c.weightInKg() + "kg)")
				.collect(Collectors.toList());

		System.out.println("Big cats sorted by weight: " + sortedBigCatsByWeight);
	}
}