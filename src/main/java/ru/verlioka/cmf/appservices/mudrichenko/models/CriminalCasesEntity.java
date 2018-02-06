package ru.verlioka.cmf.appservices.mudrichenko.models;

import javax.persistence.*;

@Entity
@Table(name = "criminal_cases")
public class CriminalCasesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "article_id" )
    private int article_id;

    @ManyToOne
    @JoinColumn( name = "investigator_id" )
    private String investigator_id;

    @ManyToOne
    @JoinColumn( name = "defendats_id" )
    private String defendats_id;

    @Column( name = "notes" )
    private String notes;

    @Column( name = "entry_date" )
    private String entry_date;

    @Column( name = "date_of_trial" )
    private String date_of_trial;

    @Column( name = "is_uncovered" )
    private boolean is_uncovered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getInvestigator_id() {
        return investigator_id;
    }

    public void setInvestigator_id(String investigator_id) {
        this.investigator_id = investigator_id;
    }

    public String getDefendats_id() {
        return defendats_id;
    }

    public void setDefendats_id(String defendats_id) {
        this.defendats_id = defendats_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getDate_of_trial() {
        return date_of_trial;
    }

    public void setDate_of_trial(String date_of_trial) {
        this.date_of_trial = date_of_trial;
    }

    public boolean getIs_uncovered() {
        return is_uncovered;
    }

    public void setIs_uncovered(boolean is_uncovered) {
        this.is_uncovered = is_uncovered;
    }

    @Override
    public String toString() {
        return "CriminalCasesEntity{" +
                "id=" + id +
                ", article_id='" + article_id +
                ", investigator_id='" + investigator_id +
                ", defendats_id='" + defendats_id +
                ", notes='" + notes + '\'' +
                ", entry_date='" + entry_date + '\'' +
                ", date_of_trial='" + date_of_trial + '\'' +
                ", is_uncovered='" + is_uncovered + '\'' +
                '}';
    }
}
