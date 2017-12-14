package ru.verlioka.cmf.appservices.libraryfund.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book_series")
public class BookSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Long id;

    @Column(name = "series_num")
    private Long seriesNum;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "batch_number")
    private Long batchNumber;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "series_name")
    private String seriesName;

    @Column(name = "book_num")
    private Long bookNum;

    public BookSeries() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeriesNum() {
        return seriesNum;
    }

    public void setSeriesNum(Long seriesNum) {
        this.seriesNum = seriesNum;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Long batchNumber) {
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

    public Long getBookNum() {
        return bookNum;
    }

    public void setBookNum(Long bookNum) {
        this.bookNum = bookNum;
    }
}
