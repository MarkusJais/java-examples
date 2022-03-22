package de.markusjais.javaexamples.records;

import java.util.List;

enum Language {
    EN,
    ES
}

record Book(String title, String author, Language language) {

    Book  {
        if(title == null || title.length() < 3) {
            throw new IllegalArgumentException("title invalid");
        }
    }

    Book(String title, String author) {
        this(title, author, Language.EN);
    }

    boolean isSpanish() {
        return language == Language.ES;
    }

    public String titleInUpperCase() {
        return title.toUpperCase();
    }
}

record BookCollection(List<Book> books) {
    BookCollection(List<Book> books) {
        this.books = List.copyOf(books);
    }
}

public class BookRecordExample {
    public static void main(String[] args) {
        var greatExpectations = new Book ("Great Expectations", "Charles Dickens");
        var terraAlta = new Book ("Terra Alta", "Javier Cercas", Language.ES);

        if(terraAlta.isSpanish()) {
            System.out.println("Highly recommend Spanish book: " + terraAlta);
        }

        System.out.printf("The language of %s by %s is: %s\n",
                greatExpectations.titleInUpperCase(), greatExpectations.author(), greatExpectations.language());

        //var invalidBook = new Book ("t", "Charles Dickens");

    }
}
