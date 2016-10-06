package uk.me.eastmans.admin.model;

import javax.persistence.*;

@Entity
public class UserMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Person forWho;

    @Column
    private boolean read;

    @Column
    private String message;

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

    public Person getForWho() {
        return forWho;
    }

    public void setForWho(Person forWho) {
        this.forWho = forWho;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserMessageClassification getClassification() {
        return classification;
    }

    public void setClassification(UserMessageClassification classification) {
        this.classification = classification;
    }
}