package com.moaa.domain.books.properties;

import java.util.Objects;
import java.util.Random;

import static java.lang.String.format;

public class Isbn {

    private String isbnNumber;

    private Isbn() {}

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

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public String toString() {
        return isbnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn = (Isbn) o;
        return Objects.equals(isbnNumber, isbn.isbnNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbnNumber);
    }
}
