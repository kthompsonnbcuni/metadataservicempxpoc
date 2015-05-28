package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class PlayerEntry {


    @Id
    private Long playerId;
    private Long added;
    private String addedByUserId;

    private String[] adminTags;
    private String adPolicyId;
    private Boolean allowEmail;
    private Boolean allowEmbed;
    private Boolean allowFullScreen;
    private Boolean allowGetLink;
    private Boolean allowRss;
    private Boolean allowSearch;
    private Boolean alwaysShowOverlay;
    private Integer aspectRatioHeight;
    private Integer aspectRatioWidth;
    private Boolean autoPlay;
    private Boolean autoInitialize;

    private String backgroundImageUrl;
    private String colorSchemeId;
    private Integer columns;
    private String controlLayoutXml;
    private Integer controlRackHeight;
    private String customCss;
    private String[] customCssUrls;
    private String customHtml;
    private String customJavaScript;
    private String[] customJavaScriptUrls;
    private Map<String, String> customProperties;
    private String description;
    private Boolean disabled;

    private String embedAdPolicyId;
    private Boolean embedAllowFullScreen;
    private Integer embedHeight;
    private String embedRestrictionId;
    private Integer embedWidth;

    private final List<PlugInInstance> enabledPlugIns = new ArrayList<PlugInInstance>();
    private Boolean enableExternalController;
    private String endCardFeedUrl;

    private String feedUrl;
    private String feedUrlParams;
    private String guid;

    private Integer headerImageHeight;
    private String headerImageUrl;
    private Integer height;

    @JsonProperty("id")
    private String idUri;
    private Boolean includeDefaultCss;
    private Integer itemsPerPage;
    private String layoutId;
    private String[] limitToCategories;
    private String linkUrl;
    private Boolean locked;
    private String overlayImageUrl;
    private String ownerId;
    private Integer paddingBottom;
    private Integer paddingLeft;
    private Integer paddingRight;
    private Integer paddingTop;
    private String pid;
    private Boolean playAll;
    private String playerUrl;

    private String[] preferredFormats;
    private String[] preferredRuntimes;
    private Map<String, Integer> regionWidths;
    private Map<String, Integer> regionHeights;
    private String releaseUrlParams;
    private String restrictionId;
    private Boolean showAirdate;
    private Boolean showAllChoice;
    private Boolean showAuthor;
    private Boolean showBitrate;
    private Boolean showFullTime;
    private Boolean showMostPopularChoice;
    private Boolean showNav;
    private Boolean shuffle;
    private String skinId;
    private Integer thumbnailHeight;
    private Integer thumbnailWidth;
    private String title;
    private Long updated;
    private String updatedByUserId;
    private Boolean useFloatingControls;
    private Long version;
    private Integer width;

    public Long getPlayerId() {
        return playerId;
    }

    public String getIdUri() {
        return idUri;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getAdded() {
        return added;
    }

    public String getAddedByUserId() {
        return addedByUserId;
    }

    //Added .clone for Malicious code vulnerability - May expose internal representation by returning reference to mutable object
    public String[] getAdminTags() {
        return adminTags.clone();
    }

    public String getAdPolicyId() {
        return adPolicyId;
    }

    public Boolean getAllowEmail() {
        return allowEmail;
    }

    public Boolean getAllowEmbed() {
        return allowEmbed;
    }

    public Boolean getAllowFullScreen() {
        return allowFullScreen;
    }

    public Boolean getAllowGetLink() {
        return allowGetLink;
    }

    public Boolean getAllowRss() {
        return allowRss;
    }

    public Boolean getAllowSearch() {
        return allowSearch;
    }

    public Boolean getAlwaysShowOverlay() {
        return alwaysShowOverlay;
    }

    public Integer getAspectRatioHeight() {
        return aspectRatioHeight;
    }

    public Integer getAspectRatioWidth() {
        return aspectRatioWidth;
    }

    public Boolean getAutoPlay() {
        return autoPlay;
    }

    public Boolean getAutoInitialize() {
        return autoInitialize;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public String getColorSchemeId() {
        return colorSchemeId;
    }

    public Integer getColumns() {
        return columns;
    }

    public String getControlLayoutXml() {
        return controlLayoutXml;
    }

    public Integer getControlRackHeight() {
        return controlRackHeight;
    }

    public String getCustomCss() {
        return customCss;
    }

    public String[] getCustomCssUrls() {
        return customCssUrls.clone();
    }

    public String getCustomHtml() {
        return customHtml;
    }

    public String getCustomJavaScript() {
        return customJavaScript;
    }

    public String[] getCustomJavaScriptUrls() {
        return customJavaScriptUrls.clone();
    }

    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public String getEmbedAdPolicyId() {
        return embedAdPolicyId;
    }

    public Boolean getEmbedAllowFullScreen() {
        return embedAllowFullScreen;
    }

    public Integer getEmbedHeight() {
        return embedHeight;
    }

    public String getEmbedRestrictionId() {
        return embedRestrictionId;
    }

    public Integer getEmbedWidth() {
        return embedWidth;
    }

    public List<PlugInInstance> getEnabledPlugIns() {
        return enabledPlugIns;
    }

    public Boolean getEnableExternalController() {
        return enableExternalController;
    }

    public String getEndCardFeedUrl() {
        return endCardFeedUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public String getFeedUrlParams() {
        return feedUrlParams;
    }

    public String getGuid() {
        return guid;
    }

    public Integer getHeaderImageHeight() {
        return headerImageHeight;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getIncludeDefaultCss() {
        return includeDefaultCss;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public String[] getLimitToCategories() {
        return limitToCategories.clone();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public Boolean getLocked() {
        return locked;
    }

    public String getOverlayImageUrl() {
        return overlayImageUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Integer getPaddingBottom() {
        return paddingBottom;
    }

    public Integer getPaddingLeft() {
        return paddingLeft;
    }

    public Integer getPaddingRight() {
        return paddingRight;
    }

    public Integer getPaddingTop() {
        return paddingTop;
    }

    public String getPid() {
        return pid;
    }

    public Boolean getPlayAll() {
        return playAll;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public String[] getPreferredFormats() {
        return preferredFormats.clone();
    }

    public String[] getPreferredRuntimes() {
        return preferredRuntimes.clone();
    }

    public Map<String, Integer> getRegionWidths() {
        return regionWidths;
    }

    public Map<String, Integer> getRegionHeights() {
        return regionHeights;
    }

    public String getReleaseUrlParams() {
        return releaseUrlParams;
    }

    public String getRestrictionId() {
        return restrictionId;
    }

    public Boolean getShowAirdate() {
        return showAirdate;
    }

    public Boolean getShowAllChoice() {
        return showAllChoice;
    }

    public Boolean getShowAuthor() {
        return showAuthor;
    }

    public Boolean getShowBitrate() {
        return showBitrate;
    }

    public Boolean getShowFullTime() {
        return showFullTime;
    }

    public Boolean getShowMostPopularChoice() {
        return showMostPopularChoice;
    }

    public Boolean getShowNav() {
        return showNav;
    }

    public Boolean getShuffle() {
        return shuffle;
    }

    public String getSkinId() {
        return skinId;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
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

    public Boolean getUseFloatingControls() {
        return useFloatingControls;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getWidth() {
        return width;
    }
}
