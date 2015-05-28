package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Release {
    private Long added;
    private String addedByUserId;
    private String adPolicyId;
    private Boolean approved;
    private Delivery delivery;
    private String description;
    private String fileId;
    private String guid;

    @Id
    private String id;
    private Boolean locked;
    private String mediaId;
    private String ownerId;
    private String parameters;
    private String pid;
    private String restrictionId;
    private String title;
    private Long updated;
    private String updatedByUserId;
    private String url;
    private Long version;

    public Long getAdded() {
        return added;
    }

    public String getAddedByUserId() {
        return addedByUserId;
    }

    public String getAdPolicyId() {
        return adPolicyId;
    }

    public Boolean getApproved() {
        return approved;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public String getDescription() {
        return description;
    }

    public String getFileId() {
        return fileId;
    }

    public String getGuid() {
        return guid;
    }

    public String getId() {
        return id;
    }

    public Boolean getLocked() {
        return locked;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getParameters() {
        return parameters;
    }

    public String getPid() {
        return pid;
    }

    public String getRestrictionId() {
        return restrictionId;
    }

    public String getTitle() {
        return title;
    }

    public Long getUpdated() {
        return updated;
    }

    public String getUpdatedByUserId() {
        return updatedByUserId;
    }

    public String getUrl() {
        return url;
    }

    public Long getVersion() {
        return version;
    }
}
