package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Rating {

    private String rating;
    private String scheme;
    private List<String> subRatings;

    public String getRating() {
        return rating;
    }

    public String getScheme() {
        return scheme;
    }

    public List<String> getSubRatings() {
        return subRatings;
    }
}
