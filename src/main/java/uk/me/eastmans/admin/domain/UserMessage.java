package uk.me.eastmans.admin.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User forWho;

    @Column
    private boolean read;

    @Column
    private String message;

    @Column
    private Date whenSent = new Date();

    @Enumerated(EnumType.STRING)
    private UserMessageClassification classification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public User getForWho() {
        return forWho;
    }

    public void setForWho(User forWho) {
        this.forWho = forWho;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getWhenSent() {
        return whenSent;
    }

    public void setWhenSent(Date whenSent) {
        this.whenSent = whenSent;
    }

    public UserMessageClassification getClassification() {
        return classification;
    }

    public void setClassification(UserMessageClassification classification) {
        this.classification = classification;
    }
}