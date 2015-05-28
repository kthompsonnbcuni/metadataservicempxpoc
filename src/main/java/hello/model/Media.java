package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Media {

    private final List<MediaEntry> entries = new ArrayList<MediaEntry>();

    public List<MediaEntry> getEntries() {
        return entries;
    }
}
