package hello.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import hello.resource.AbstractResource;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hello.resource.AbstractResource.EMBEDDED_PROPERTY;
import static hello.resource.AbstractResource.LINKS_PROPERTY;

//import static hello.resource.MediaResource.ADDED_BY_USER_ID_PROPERTY;
import static hello.resource.MediaResource.*;

@JsonPropertyOrder({ LINKS_PROPERTY, EMBEDDED_PROPERTY,ADDED_PROPERTY,ADDED_BY_USER_ID_PROPERTY,ADMIN_TAGS_PROPERTY,
        AD_POLICY_ID_PROPERTY,APPROVED_PROPERTY,AUTHOR_PROPERTY,AUTHOR_LOCALIZED_PROPERTY,AVAILABILITY_STATE_PROPERTY,
        AVAILABLE_DATE_PROPERTY,CATEGORIES_PROPERTY,CATEGORY_ID_PROPERTY,CHAPTERS_PROPERTY,CONTENT_PROPERTY,COPYRIGHT_LOCALIZED_PROPERTY,
        COPYRIGHT_URL_PROPERTY,COPYRIGHT_URL_LOCALIZED_PROPERTY, COUNTRIES_PROPERTY,CREDITS_PROPERTY,DEFAULT_THUMBNAIL_URL_PROPERTY,
        DESCRIPTION_PROPERTY, DESCRIPTION_LOCALIZED_PROPERTY,EXCLUDE_COUNTRIES_PROPERTY,EXPIRATION_DATE_PROPERTY,GU_ID_PROPERTY,
        ID_PROPERTY,KEYWORDS_PROPERTY,KEYWORDS_LOCALIZED_PROPERTY,LINK_PROPERTY, LINK_LOCALIZED_PROPERTY,LOCKED_PROPERTY,
        ORIGINAL_MEDIA_ID_PROPERTY,ORIGINAL_OWNER_ID_PROPERTY,OWNER_ID_PROPERTY,PID_PROPERTY,PROGRAM_ID_PROPERTY,PROVIDER_PROPERTY,
        PROVIDER_ID_PROPERTY,PUB_DATE_PROPERTY,PUBLIC_URL_PROPERTY,RATINGS_PROPERTY,RESTRICTION_ID_PROPERTY,SERIES_ID_PROPERTY,
        TEXT_PROPERTY,TEXT_LOCALIZED_PROPERTY,THUMBNAILS_PROPERTY,TITLE_PROPERTY,TITLE_LOCALIZED_PROPERTY,UPDATED_PROPERTY,
        UPDATE_BY_USER_ID_PROPERTY,VERSION_PROPERTY


})
public class MediaResource extends AbstractResource {

    public static final String ADDED_PROPERTY = "added";
    public static final String ADDED_BY_USER_ID_PROPERTY = "addedByUserId";
    public static final String ADMIN_TAGS_PROPERTY = "adminTags";
    public static final String AD_POLICY_ID_PROPERTY = "adPolicyId";
    public static final String APPROVED_PROPERTY = "approved";
    public static final String AUTHOR_PROPERTY = "author";
    public static final String AUTHOR_LOCALIZED_PROPERTY = "authorLocalized";
    public static final String AVAILABILITY_STATE_PROPERTY = "availabilityState";
    public static final String AVAILABLE_DATE_PROPERTY = "availableDate";
    public static final String CATEGORIES_PROPERTY = "categories";
    public static final String CATEGORY_ID_PROPERTY = "categoryIds";
    public static final String CHAPTERS_PROPERTY = "chapters";

    public static final String CONTENT_PROPERTY = "content";
    public static final String COPYRIGHT_LOCALIZED_PROPERTY = "copyrightLocalized";
    public static final String COPYRIGHT_URL_PROPERTY = "copyrightUrl";
    public static final String COPYRIGHT_URL_LOCALIZED_PROPERTY = "copyrightUrlLocalized";
    public static final String COUNTRIES_PROPERTY = "countries";
    public static final String CREDITS_PROPERTY = "credits";
    public static final String DEFAULT_THUMBNAIL_URL_PROPERTY = "defaultThumbnailUrl";
    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String DESCRIPTION_LOCALIZED_PROPERTY = "descriptionLocalized";
    public static final String EXCLUDE_COUNTRIES_PROPERTY = "excludeCountries";
    public static final String EXPIRATION_DATE_PROPERTY = "expirationDate";
    public static final String GU_ID_PROPERTY = "guid";

    public static final String ID_PROPERTY = "id";
    public static final String KEYWORDS_PROPERTY = "keywords";
    public static final String KEYWORDS_LOCALIZED_PROPERTY = "keywordsLocalized";

    public static final String LINK_PROPERTY = "link";
    public static final String LINK_LOCALIZED_PROPERTY = "linkLocalized";
    public static final String LOCKED_PROPERTY = "locked";

    public static final String ORIGINAL_MEDIA_ID_PROPERTY = "originalMediaIds";
    public static final String ORIGINAL_OWNER_ID_PROPERTY = "originalOwnerIds";
    public static final String OWNER_ID_PROPERTY = "ownerId";
    public static final String PID_PROPERTY = "pid";

    public static final String PROGRAM_ID_PROPERTY = "programId";
    public static final String PROVIDER_PROPERTY = "provider";
    public static final String PROVIDER_ID_PROPERTY = "providerId";
    public static final String PUB_DATE_PROPERTY = "pubDate";
    public static final String PUBLIC_URL_PROPERTY = "publicUrl";
    public static final String RATINGS_PROPERTY = "ratings";
    public static final String RESTRICTION_ID_PROPERTY = "restrictionId";
    public static final String SERIES_ID_PROPERTY = "seriesId";
    public static final String TEXT_PROPERTY = "text";
    public static final String TEXT_LOCALIZED_PROPERTY = "textLocalized";
    public static final String THUMBNAILS_PROPERTY = "thumbnails";
    public static final String TITLE_PROPERTY = "title";
    public static final String TITLE_LOCALIZED_PROPERTY = "titleLocalized";

    public static final String UPDATED_PROPERTY = "updated";
    public static final String UPDATE_BY_USER_ID_PROPERTY = "updatedByUserId";
    public static final String VERSION_PROPERTY = "version";


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

    private List<MediaFile> content = new ArrayList<MediaFile>();
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
    //@Id
    private String id;
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


    public String getMId() {
        return id;
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

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setAdded(Long added) {
        this.added = added;
    }

    public void setAddedByUserId(String addedByUserId) {
        this.addedByUserId = addedByUserId;
    }

    public void setAdminTags(String[] adminTags) {
        this.adminTags = adminTags;
    }

    public void setAdPolicyId(String adPolicyId) {
        this.adPolicyId = adPolicyId;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthorLocalized(Map<String, String> authorLocalized) {
        this.authorLocalized = authorLocalized;
    }

    public void setAvailabilityState(AvailabilityState availabilityState) {
        this.availabilityState = availabilityState;
    }

    public void setAvailableDate(Long availableDate) {
        this.availableDate = availableDate;
    }

    public void setCategories(List<CategoryInfo> categories) {
        this.categories = categories;
    }

    public void setCategoryIds(List categoryIds) {
        this.categoryIds = categoryIds;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setCopyrightLocalized(Map<String, String> copyrightLocalized) {
        this.copyrightLocalized = copyrightLocalized;
    }

    public void setCopyrightUrl(String copyrightUrl) {
        this.copyrightUrl = copyrightUrl;
    }

    public void setCopyrightUrlLocalized(Map<String, String> copyrightUrlLocalized) {
        this.copyrightUrlLocalized = copyrightUrlLocalized;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public void setDefaultThumbnailUrl(String defaultThumbnailUrl) {
        this.defaultThumbnailUrl = defaultThumbnailUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescriptionLocalized(Map<String, String> descriptionLocalized) {
        this.descriptionLocalized = descriptionLocalized;
    }

    public void setExcludeCountries(Boolean excludeCountries) {
        this.excludeCountries = excludeCountries;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setKeywordsLocalized(Map<String, String> keywordsLocalized) {
        this.keywordsLocalized = keywordsLocalized;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLinkLocalized(Map<String, String> linkLocalized) {
        this.linkLocalized = linkLocalized;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public void setOriginalMediaIds(List<String> originalMediaIds) {
        this.originalMediaIds = originalMediaIds;
    }

    public void setOriginalOwnerIds(List<String> originalOwnerIds) {
        this.originalOwnerIds = originalOwnerIds;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public void setPubDate(Long pubDate) {
        this.pubDate = pubDate;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setRestrictionId(String restrictionId) {
        this.restrictionId = restrictionId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextLocalized(Map<String, String> textLocalized) {
        this.textLocalized = textLocalized;
    }

    public void setThumbnails(List<MediaFile> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public void setContent(List<MediaFile> content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleLocalized(Map<String, String> titleLocalized) {
        this.titleLocalized = titleLocalized;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public void setUpdatedByUserId(String updatedByUserId) {
        this.updatedByUserId = updatedByUserId;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        //MediaResource otherAvailableAsset = (MediaResource) obj;

        return false;/*new EqualsBuilder()
                .append(format, otherAvailableAsset.format)
                .append(assetTypes, otherAvailableAsset.assetTypes)
                .append(url, otherAvailableAsset.url)
                .isEquals();*/
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, null, false, MediaResource.class);
    }

}
