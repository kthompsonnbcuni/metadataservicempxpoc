package hello.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)

public class MediaEntry implements Serializable {


    @Id
    private Long mediaId;
    @JsonProperty("$xmlns")
    private LinkedHashMap<String,String> nameSpace;
    private Long added;
    private String addedByUserId;
    private String[] adminTags;
    private String adPolicyId;
    private boolean approved;
    private String author;
    private Map<String, String> authorLocalized;
    private AvailabilityState availabilityState;
    private Long availableDate;
    private List<CategoryInfo> categories;
    private List categoryIds;
    private List<Chapter> chapters;

    private final List<MediaFile> content = new ArrayList<MediaFile>();
    private String copyright;
    private Map<String, String> copyrightLocalized;
    private String copyrightUrl;
    private Map<String, String> copyrightUrlLocalized;
    private String[] countries;
    private List<Credit> credits;
    private String defaultThumbnailUrl;
    private String description;
    private Map<String, String> descriptionLocalized;
    private Boolean excludeCountries;
    private Long expirationDate;
    private String guid;

    @JsonProperty("id")
    private String idUri;
    private String keywords;
    private Map<String, String> keywordsLocalized;

    private String link;
    private Map<String, String> linkLocalized;
    private Boolean locked;

    private List<String> originalMediaIds;
    private List<String> originalOwnerIds;
    private String ownerId;
    private String pid;

    private String programId;
    private String provider;
    private String providerId;
    private Long pubDate;
    private String publicUrl;
    private List<Rating> ratings;
    private String restrictionId;
    private String seriesId;
    private String text;
    private Map<String, String> textLocalized;
    private List<MediaFile> thumbnails;
    private String title;
    private Map<String, String> titleLocalized;

    private Long updated;
    private String updatedByUserId;
    private Long version;
    private LinkedHashMap<String,String> customProperties = new LinkedHashMap<>();
    public Long getAdded() {
        return added;
    }

    public String getAddedByUserId() {
        return addedByUserId;
    }

    public String[] getAdminTags() {
        return adminTags.clone();
    }

    public String getAdPolicyId() {
        return adPolicyId;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getAuthor() {
        return author;
    }

    public Map<String, String> getAuthorLocalized() {
        return authorLocalized;
    }

    public AvailabilityState getAvailabilityState() {
        return availabilityState;
    }

    public Long getAvailableDate() {
        return availableDate;
    }

    public List<CategoryInfo> getCategories() {
        return categories;
    }

    public List getCategoryIds() {
        return categoryIds;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public List<MediaFile> getContent() {
        return content;
    }

    public String getCopyright() {
        return copyright;
    }

    public Map<String, String> getCopyrightLocalized() {
        return copyrightLocalized;
    }

    public String getCopyrightUrl() {
        return copyrightUrl;
    }

    public Map<String, String> getCopyrightUrlLocalized() {
        return copyrightUrlLocalized;
    }

    public String[] getCountries() {
        return countries.clone();
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public String getDefaultThumbnailUrl() {
        return defaultThumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getDescriptionLocalized() {
        return descriptionLocalized;
    }

    public Boolean getExcludeCountries() {
        return excludeCountries;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public String getGuid() {
        return guid;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getIdUri() {
        return idUri;
    }

    public String getKeywords() {
        return keywords;
    }

    public Map<String, String> getKeywordsLocalized() {
        return keywordsLocalized;
    }

    public String getLink() {
        return link;
    }

    public Map<String, String> getLinkLocalized() {
        return linkLocalized;
    }

    public Boolean getLocked() {
        return locked;
    }

    public List<String> getOriginalMediaIds() {
        return originalMediaIds;
    }

    public List<String> getOriginalOwnerIds() {
        return originalOwnerIds;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getPid() {
        return pid;
    }

    public String getProgramId() {
        return programId;
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public Long getPubDate() {
        return pubDate;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public String getRestrictionId() {
        return restrictionId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getText() {
        return text;
    }

    public Map<String, String> getTextLocalized() {
        return textLocalized;
    }

    public List<MediaFile> getThumbnails() {
        return thumbnails;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, String> getTitleLocalized() {
        return titleLocalized;
    }

    public Long getUpdated() {
        return updated;
    }

    public String getUpdatedByUserId() {
        return updatedByUserId;
    }

    public Long getVersion() {
        return version;
    }

    public LinkedHashMap<String, String> getNameSpace() {
        return nameSpace;
    }


    public LinkedHashMap<String, String> getCustomProperties() {
        return customProperties;
    }

    @JsonAnySetter
    public void setCustomProperties(String name, String value) {
        customProperties.put(name, value);

    }

    public void setNameSpace(LinkedHashMap<String, String> nameSpace) {
        this.nameSpace = nameSpace;
    }
}
