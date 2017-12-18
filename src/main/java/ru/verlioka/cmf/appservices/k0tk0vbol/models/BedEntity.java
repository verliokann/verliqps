package ru.verlioka.cmf.appservices.k0tk0vbol.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Max on 13.12.2017.
 *
public class BedEntity {

    @Id
    @Column(name = "bedsid")
    private int id;

    @ManyToOne
    @JoinColumn(name = "doc")
    private int DocId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocId() {
        return DocId;
    }

    public void setDocId(int docId) {
        DocId = docId;
    }

    @Override
    public String toString() {
        return "BedEntity{" +
                "id=" + id +
                ", DocId=" + DocId +
                '}';
    }
}
*/