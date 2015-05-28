package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class PlugInInstance {


    private String plugInId;

    private String regionName;

    private Param params;

    public String getPlugInId() {
        return plugInId;
    }

    public String getRegionName() {
        return regionName;
    }

    public Param getParams() {
        return params;
    }
}
