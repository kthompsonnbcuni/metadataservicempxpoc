package hello.resource;

import hello.MediaController;
import hello.model.MediaEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class MediaObjectResourceAssembler extends ResourceAssemblerSupport<MediaEntry, MediaResource> {

    //s@Autowired
    //private ConversionService conversionService;

    @Autowired
    private ResourceLinkBuilder resourceLinkBuilder;

    public MediaObjectResourceAssembler() {
        super(MediaController.class, MediaResource.class);
    }

    @Override
    public MediaResource toResource(MediaEntry entity) {

        if(entity==null)
            System.out.println("Entity is NULL");

        MediaResource mediaResource = createResource(entity);

        // Create self link
        mediaResource.add(resourceLinkBuilder.selfLinkToMedia(entity.getIdUri()));

        return mediaResource;
    }

    private MediaResource createResource(MediaEntry entity) {
        MediaResource resource = new MediaResource();

        resource.setAdded(entity.getAdded());
        resource.setAddedByUserId(entity.getAddedByUserId());
        resource.setAdminTags(entity.getAdminTags());
        resource.setAdPolicyId(entity.getAdPolicyId());
        resource.setApproved(entity.isApproved());
        resource.setAuthor(entity.getAuthor());
        resource.setAuthorLocalized(entity.getAuthorLocalized());
        resource.setAvailabilityState(entity.getAvailabilityState());
        resource.setAvailableDate(entity.getAvailableDate());
        resource.setCategories(entity.getCategories());
        resource.setCategoryIds(entity.getCategoryIds());
        resource.setChapters(entity.getChapters());

        resource.setThumbnails(entity.getThumbnails());
        resource.setContent(entity.getContent());
        resource.setCopyright(entity.getCopyright());
        resource.setCopyrightLocalized(entity.getCopyrightLocalized());
        resource.setCopyrightUrl(entity.getCopyrightUrl());
        resource.setCopyrightUrlLocalized(entity.getCopyrightUrlLocalized());
        resource.setCountries(entity.getCountries());
        resource.setCredits(entity.getCredits());
        resource.setDefaultThumbnailUrl(entity.getDefaultThumbnailUrl());
        resource.setDescription(entity.getDescription());
        resource.setDescriptionLocalized(entity.getDescriptionLocalized());
        resource.setExcludeCountries(entity.getExcludeCountries());
        resource.setExpirationDate(entity.getExpirationDate());
        resource.setGuid(entity.getGuid());

        //@Id
        resource.setId(entity.getIdUri());
        resource.setKeywords(entity.getKeywords());
        resource.setKeywordsLocalized(entity.getKeywordsLocalized());
        resource.setLink(entity.getLink());
        resource.setLinkLocalized(entity.getLinkLocalized());
        resource.setLocked(entity.getLocked());
        resource.setOriginalMediaIds(entity.getOriginalMediaIds());
        resource.setOriginalOwnerIds(entity.getOriginalOwnerIds());
        resource.setOwnerId(entity.getOwnerId());
        resource.setPid(entity.getPid());

        resource.setProgramId(entity.getProgramId());
        resource.setProvider(entity.getProvider());
        resource.setProviderId(entity.getProviderId());
        resource.setPubDate(entity.getPubDate());
        resource.setPublicUrl(entity.getPublicUrl());
        resource.setRatings(entity.getRatings());
        resource.setRestrictionId(entity.getRestrictionId());
        resource.setSeriesId(entity.getSeriesId());
        resource.setText(entity.getText());
        resource.setTextLocalized(entity.getTextLocalized());
        resource.setThumbnails(entity.getThumbnails());
        resource.setTitle(entity.getTitle());
        resource.setTitleLocalized(entity.getTitleLocalized());

        resource.setUpdated(entity.getUpdated());
        resource.setUpdatedByUserId(entity.getUpdatedByUserId());
        resource.setVersion(entity.getVersion());


//
//
//            resource.setCustomFields((Map<String, Object>) conversionService.convert(entity.getCustomFields(),
//                    TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CustomField.class)),
//                    TypeDescriptor.map(Map.class, TypeDescriptor.valueOf(String.class),
//                            TypeDescriptor.valueOf(Object.class))));


        return resource;
    }
}