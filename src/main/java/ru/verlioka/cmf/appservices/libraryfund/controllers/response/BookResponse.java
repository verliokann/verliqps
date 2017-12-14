package ru.verlioka.cmf.appservices.libraryfund.controllers.response;

import java.math.BigInteger;
import java.sql.Date;

public class BookResponse {
    private String bookName;
    private BigInteger bookNumber;
    private String author;
    private Date publishDate;
    private String publisher;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigInteger getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(BigInteger bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
