package com.markusjais.javaexamples.textblocks;



public class TextBlocksExample {

    public static void main(String[] args) {

        String greatExpectationsBeginning = """
             My father’s family name being Pirrip,
             and my Christian name Philip,
             my infant tongue could make of both names nothing longer or more explicit than Pip.
             So, I called myself Pip, and came to be called Pip.
            """;

        String bookJsonDickens = """
            {
              "author": "Charles Dickens",
              "bookTitle": "Great Expectations",
              "yearOfPublication": 1861,
              "language": "English"
            }
            """;

        String bookJsonCercas = String.format("""
            {
              "author": "%s",
              "bookTitle": "%s",
              "yearOfPublication": %d,
              "language": "%s"
            }
            """, "Javier Cercas", "Terra Alta", 2019, "Spanish");

        System.out.println(greatExpectationsBeginning);
        System.out.println(bookJsonDickens);
        System.out.println(bookJsonCercas);
    }
}
