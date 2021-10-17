package org.tech.with.orkhan.service;

import io.grpc.stub.StreamObserver;
import org.tech.with.orkhan.demo.Book;
import org.tech.with.orkhan.demo.BookServiceGrpc;

public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    @Override
    public void getBook(Book.BookRequest request, StreamObserver<Book.BookResponse> responseObserver) {
        responseObserver.onNext(getBook(request.getBookId()));
        responseObserver.onCompleted();
    }

    private Book.BookResponse getBook(int bookId) {
        //  Find book in DB
        if (bookId == 10) {
            return Book.BookResponse.newBuilder()
                    .setGenre(Book.Genre.SCI_FI)
                    .setTitle("I ROBOT")
                    .setPrice(50)
                    .build();
        }
        return Book.BookResponse.getDefaultInstance();
    }
}
