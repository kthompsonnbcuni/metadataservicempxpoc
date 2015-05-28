package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Player {
    private String startIndex;
    private String itemsPerPage;
    private String entryCount;

    public String getStartIndex() {
        return startIndex;
    }

    public String getItemsPerPage() {
        return itemsPerPage;
    }

    public String getEntryCount() {
        return entryCount;
    }

    private final List<PlayerEntry> entries = new ArrayList<PlayerEntry>();

    public List<PlayerEntry> getEntries() {
        return entries;
    }
}
