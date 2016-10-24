package uk.me.eastmans.admin.forms;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.*;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import java.util.Date;

/**
 * Created by markeastman on 20/10/2016.
 */
public class FormEntityForm {
    private Long id;

    private int version;

    private String notNull;

    @NotNull
    @FormParam("moreThanOrEqual10")
    public String moreThanOrEqual10;

    @NotNull
    @FormParam("lessThanOrEqual100")
    public String lessThanOrEqual100;

    private String futureDate;

    private String pastDate;

    private String sizeBetween6and10;

}
