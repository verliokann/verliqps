package ru.verlioka.cmf.appservices.libraryfund.models;


import javax.persistence.*;
import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book_series")
public class BookSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private int id;

    @Column(name = "series_num")
    private int seriesNum;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Book> books;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "batch_number")
    private int batchNumber;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "series_name")
    private String seriesName;

    public BookSeries() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeriesNum() {
        return seriesNum;
    }

    public void setSeriesNum(int seriesNum) {
        this.seriesNum = seriesNum;
    }


    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}
