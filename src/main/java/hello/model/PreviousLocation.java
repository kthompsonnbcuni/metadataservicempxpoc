package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class PreviousLocation {

    private String filePath;

    private String serverId;

    private Long version;

    public String getFilePath() {
        return filePath;
    }

    public String getServerId() {
        return serverId;
    }

    public Long getVersion() {
        return version;
    }
}

