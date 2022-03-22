package de.markusjais.javaexamples.files;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileWriteExample {

	static List<String> cats = List.of("Puma", "Leopard", "Manul",  "Tiger");

	public static void main(String[] args) throws Exception {

		Stream stream = cats.stream();
		Files.write(Paths.get("/tmp/stream.txt"), stream::iterator);

		Files.write(Paths.get("/tmp/iterator.txt"), cats);

	}
}