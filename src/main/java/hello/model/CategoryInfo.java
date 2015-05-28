package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CategoryInfo {

    private String name;
    private String label;
    private String scheme;

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getScheme() {
        return scheme;
    }
}
