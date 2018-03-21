package com.moaa.domain.books.properties;

import java.util.Random;

import static java.lang.String.format;

public class Isbn {

    private String isbnNumber;;

    private Isbn(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public static Isbn create() {
        Random random = new Random();
        return new Isbn(format("%d%d%d-%d-%d%d-%d%d%d%d%d%d-%d"
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
                                        , random.nextInt(10)
        ));
    }

    public static Isbn create(int seed) {
        Random random = new Random(seed);
        return new Isbn(format("%d%d%d-%d-%d%d-%d%d%d%d%d%d-%d"
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
                , random.nextInt(10)
        ));
    }

    public static Isbn convertStringToIsbn(String isbnString) {
        return new Isbn(isbnString);
    }

    @Override
    public String toString() {
        return isbnNumber;
    }


}
