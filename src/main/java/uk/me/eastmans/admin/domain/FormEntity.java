package uk.me.eastmans.admin.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by markeastman on 18/10/2016.
 */
@Entity
public class FormEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @NotNull
    private String notNull;

    @Min(10)
    private int moreThanOrEqual10;

    @Max(100)
    private int lessThanOrEqual100;

    @Future
    private Date futureDate;

    @Past
    private Date pastDate;

    @Size(min = 6, max = 10)
    private String sizeBetween6and10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public int getMoreThanOrEqual10() {
        return moreThanOrEqual10;
    }

    public void setMoreThanOrEqual10(int moreThanOrEqual10) {
        this.moreThanOrEqual10 = moreThanOrEqual10;
    }

    public int getLessThanOrEqual100() {
        return lessThanOrEqual100;
    }

    public void setLessThanOrEqual100(int lessThanOrEqual100) {
        this.lessThanOrEqual100 = lessThanOrEqual100;
    }

    public Date getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(Date futureDate) {
        this.futureDate = futureDate;
    }

    public Date getPastDate() {
        return pastDate;
    }

    public void setPastDate(Date pastDate) {
        this.pastDate = pastDate;
    }

    public String getSizeBetween6and10() {
        return sizeBetween6and10;
    }

    public void setSizeBetween6and10(String sizeBetween6and10) {
        this.sizeBetween6and10 = sizeBetween6and10;
    }
}
