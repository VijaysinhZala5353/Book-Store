package com.example.bookstore;

public class Book {
    String bookName;
    String bookAuthorName;
    Double bookPrice;

    public Book(String bookName, String bookAuthorName, Double bookPrice) {
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPrice = bookPrice;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
