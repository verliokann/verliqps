package ru.verlioka.cmf.appservices.criminal.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "criminal")
public class Criminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    /** Полное имя кента */
    private String fullName;

    /** Погоняло бродяги */
    private String nick;

    /** Статья по которой замели */
    private String article;
    
    /** Место житухи */
    private String address;
    
    /** Днюха */
    private Date birthday;

    /** Дата приговора */
    private Date courtDay;
    
    /** Порешили дело или нет */
    private Boolean isProcessed;
    
    /** Пояснение к статье */
    private String articleDescription;
    
    /** Имя следока */
    private String ment;
    
    /** Портрет бедолаги */
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nickName) {
        this.nick = nickName;
    }

    public String getArticle() {
        return this.article;
    }

    public void setArticle(String articl) {
        this.article = articl;
    }
    
    public String getAddress() {
        return this.address;
    }

    public void setAaddress(String address) {
        this.address = address;
    }
    
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getMent() {
        return this.ment;
    }

    public void setMent(String ment) {
        this.ment = ment;
    }
    
    public Date getCourtDay() {
        return this.courtDay;
    }

    public void setCourtDay(Date courtDay) {
        this.courtDay = courtDay;
    }
    
    public String getArticleDescription() {
        return this.articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }
}
