package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Credit {

    private String role;
    private String scheme;
    private String value;

    public String getRole() {
        return role;
    }

    public String getScheme() {
        return scheme;
    }

    public String getValue() {
        return value;
    }
}
