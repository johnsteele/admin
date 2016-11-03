package uk.me.eastmans.admin.forms;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by markeastman on 20/10/2016.
 */
public class FormEntityForm {
    private Long id;
    private int version;

    @NotNull
    private String notNull;

    @Min(
            value = 10,
            message = "The value must be at least {min}"
    )
    public Integer moreThanOrEqual10;

    @Max(
            value = 100,
            message = "The value must be no more than {max}"
    )
    public Integer lessThanOrEqual100;

    @Future
    private Date futureDate;

    @Past
    private Date pastDate;

    @Size(
            min = 6,
            max = 10,
            message = "The sizeBetween6and10 '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String sizeBetween6and10;

}
/*
    @DecimalMax(
            value = "350",
            message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher " +
                    "than {value}"
    )
    private double topSpeed;
*/