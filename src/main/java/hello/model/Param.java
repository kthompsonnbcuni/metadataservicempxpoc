package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Param {
    private String labelmapping;

    private String sendErrors;

    private String c2;

    private String priority;

    private String persistentlabels;

    private String timinglabel;

    private String sendload;


    public String getLabelmapping() {
        return labelmapping;
    }

    public String getSendErrors() {
        return sendErrors;
    }

    public String getC2() {
        return c2;
    }

    public String getPriority() {
        return priority;
    }

    public String getPersistentlabels() {
        return persistentlabels;
    }

    public String getTiminglabel() {
        return timinglabel;
    }

    public String getSendload() {
        return sendload;
    }
}
