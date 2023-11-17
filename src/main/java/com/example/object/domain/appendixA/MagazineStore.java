package com.example.object.domain.appendixA;

public class MagazineStore extends BookStall {
    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        return new Magazine(independentPublisher);
    }

    // 자바는 반공변성을 허용하지 않음
//    @Override
//    public Magazine sell(Publisher publisher) {
//        return new Magazine(publisher);
//    }
}