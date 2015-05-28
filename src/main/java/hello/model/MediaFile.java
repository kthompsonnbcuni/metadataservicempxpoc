package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaFile {

    private String id;
    private String guid;
    private Long updated;
    private String title;
    private String description;
    private Long added;
    private String ownerId;
    private String addedByUserId;
    private String updatedByUserId;
    private Long version;
    private Boolean locked;
    private Boolean allowRelease;
    private String[] assetTypeIds;
    private String[] assetTypes;
    private String audioCodec;
    private Long audioSampleSize;
    private String downloadUrl;
    private Boolean exists;
    private String failoverStreamingUrl;
    private String failoverSourceUrl;
    private String filePath;
    private Boolean isProtected;
    private Boolean isThumbnail;
    private String mediaId;
    private String protectionKey;
    private Release[] releases;
    private String serverId;
    private String sourceMediaFileId;
    private String sourceUrl;
    private String storageUrl;
    private String streamingUrl;
    private String transformId;
    private String videoCodec;
    private Boolean approved;
    private String protectionScheme;
    private Double aspectRatio;
    private final List<PreviousLocation> previousLocations = new ArrayList<PreviousLocation>();
    private String[] secondaryAudio;
    private Boolean closedCaptions;
    private String displayAspectRatio;
    private Long audioChannels;
    private Long audioSampleRate;
    private Long bitrate;

    private String contentType;
    private Long duration;
    private String expression;
    private Long fileSize;
    private String format;
    private Double frameRate;
    private Long height;
    private Boolean isDefault;
    private String language;
    private Long sourceTime;
    private String url;
    private Long width;


    public String getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public Long getUpdated() {
        return updated;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getAdded() {
        return added;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getAddedByUserId() {
        return addedByUserId;
    }

    public String getUpdatedByUserId() {
        return updatedByUserId;
    }

    public Long getVersion() {
        return version;
    }

    public Boolean getLocked() {
        return locked;
    }

    public Boolean getAllowRelease() {
        return allowRelease;
    }

    public String[] getAssetTypeIds() {
        return assetTypeIds.clone();
    }

    public String[] getAssetTypes() {
        return assetTypes.clone();
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public Long getAudioSampleSize() {
        return audioSampleSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Boolean getExists() {
        return exists;
    }

    public String getFailoverStreamingUrl() {
        return failoverStreamingUrl;
    }

    public String getFailoverSourceUrl() {
        return failoverSourceUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public Boolean getIsProtected() {
        return isProtected;
    }

    public Boolean getIsThumbnail() {
        return isThumbnail;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getProtectionKey() {
        return protectionKey;
    }

    public Release[] getReleases() {
        return releases.clone();
    }

    public String getServerId() {
        return serverId;
    }

    public String getSourceMediaFileId() {
        return sourceMediaFileId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public String getStreamingUrl() {
        return streamingUrl;
    }

    public String getTransformId() {
        return transformId;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getProtectionScheme() {
        return protectionScheme;
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public List<PreviousLocation> getPreviousLocations() {
        return previousLocations;
    }

    public String[] getSecondaryAudio() {
        return secondaryAudio.clone();
    }

    public Boolean getClosedCaptions() {
        return closedCaptions;
    }

    public String getDisplayAspectRatio() {
        return displayAspectRatio;
    }

    public Long getAudioChannels() {
        return audioChannels;
    }

    public Long getAudioSampleRate() {
        return audioSampleRate;
    }

    public Long getBitrate() {
        return bitrate;
    }

    public String getContentType() {
        return contentType;
    }

    public Long getDuration() {
        return duration;
    }

    public String getExpression() {
        return expression;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getFormat() {
        return format;
    }

    public Double getFrameRate() {
        return frameRate;
    }

    public Long getHeight() {
        return height;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public String getLanguage() {
        return language;
    }

    public Long getSourceTime() {
        return sourceTime;
    }

    public String getUrl() {
        return url;
    }

    public Long getWidth() {
        return width;
    }

}
