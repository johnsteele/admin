package uk.me.eastmans.admin.forms;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by markeastman on 20/10/2016.
 */
public class FormEntityForm {
    private Long id = null;
    private int version = 0;

    @NotNull
    private String notNull;

    @Min(
            value = 10,
            message = "The value must be at least {value}"
    )
    public Integer moreThanOrEqual10;

    @Max(
            value = 100,
            message = "The value must be no more than {value}"
    )
    public Integer lessThanOrEqual100;

    @
    @Future
    private Date futureDate;

    @Null
    @Past
    private Date pastDate;

    @Size(
            min = 6,
            max = 10,
            message = "The sizeBetween6and10 '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String sizeBetween6and10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public Integer getMoreThanOrEqual10() {
        return moreThanOrEqual10;
    }

    public void setMoreThanOrEqual10(Integer moreThanOrEqual10) {
        this.moreThanOrEqual10 = moreThanOrEqual10;
    }

    public Integer getLessThanOrEqual100() {
        return lessThanOrEqual100;
    }

    public void setLessThanOrEqual100(Integer lessThanOrEqual100) {
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
/*
    @DecimalMax(
            value = "350",
            message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher " +
                    "than {value}"
    )
    private double topSpeed;
*/