package com.markusjais.javaexamples.records;

enum Language {
    EN,
    ES
}

record Book(String title, String author, Language language) {
    Book(String title, String author) {
        this(title, author, Language.EN);
    }

    boolean isSpanish() {
        return language == Language.ES;
    }
}

public class BookRecordExample {
    public static void main(String[] args) {
        var greatExpectations = new Book ("Great Expectations", "Charles Dickens");
        var terraAlta = new Book ("Terra Alta", "Javier Cercas", Language.ES);

        if(terraAlta.isSpanish()) {
            System.out.println("Highly recommend Spanish book: " + terraAlta);
        }

        System.out.printf("The language of %s by %s is: %s",
                greatExpectations.title(), greatExpectations.author(), greatExpectations.language());
    }
}
