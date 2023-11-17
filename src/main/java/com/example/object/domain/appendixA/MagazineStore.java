package com.example.object.domain.appendixA;

public class MagazineStore extends BookStall {
    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        return new Magazine(independentPublisher);
    }
}
