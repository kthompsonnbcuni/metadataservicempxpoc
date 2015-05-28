package hello;

import hello.model.MediaEntry;
import hello.repository.MpxMediaEntryRepository;
import hello.resource.MpxMediaResource;
import hello.resource.MpxMediaResourceAssembler;
import hello.resource.ResourceLinkBuilder;
import hello.resource.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static hello.MediaController.APPLICATION_HAL_JSON;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//import static hello.MediaController.APPLICATION_JSON;




@RestController
//@RequestMapping(produces = APPLICATION_HAL_JSON)
@RequestMapping(value = "/media", produces = APPLICATION_HAL_JSON)
public class MediaController {//extends AbstractRestController {

    @Autowired
    private MediaEntryRepository mediaEntryRepository;

    @Autowired
    private MpxMediaEntryRepository mpxMediaEntryRepository;

    public static final String APPLICATION_HAL_JSON = "application/hal+json; charset=UTF-8";
    public static final String APPLICATION_JSON= "application/json; charset=UTF-8";

    @Autowired
    private MpxMediaResourceAssembler mpxmediaResourceAssembler;

    @Autowired
    private org.springframework.data.web.PagedResourcesAssembler<MediaEntry> collectionPagedResourcesAssembler;
    //private hello.resource.PagedResourcesAssembler<MediaEntry> collectionPagedResourcesAssembler;
    //private org.springframework.data.web.PagedResourcesAssembler<MediaEntry> collectionPagedResourcesAssembler;

    @Autowired
    private ResourceLinkBuilder resourceLinkBuilder;


    /**
     * Returns media objects in HAL+JSON with pagination.

     * @param pageable
     //* @param assembler
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<MpxMediaResource>> getMpxMedia(
            @PageableDefault(size = UtilConstants.DEFAULT_RETURN_RECORD_COUNT, page = 1)Pageable pageable,
            org.springframework.data.web.PagedResourcesAssembler<MediaEntry> assembler) {

        Page<MediaEntry> mediaEntries = mpxMediaEntryRepository.findAll(pageable);
        //this.mediaEntryRepository.getAllMedia(pageable);//newsArticleRepository.findAll(filters, pageable);
        Link selfLink = linkTo(methodOn(MediaController.class).getMpxMedia(pageable,assembler)).withSelfRel();
       PagedResources<MpxMediaResource> mpxMediaResources = collectionPagedResourcesAssembler.toResource(
                mediaEntries, mpxmediaResourceAssembler, selfLink);
       // mpxMediaResources.add(resourceLinkBuilder.linkToMedias());

       return response(mpxMediaResources, HttpStatus.OK);

    }



    /**
     * Returns public media by id. HAL+JSON
     *
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public HttpEntity<MpxMediaResource> getMediaById(@PathVariable("id") String id)
            throws ResourceNotFoundException {

        MediaEntry media = getMpxMediaById(id);//mediaEntryRepository.getMediaById(id);
        MpxMediaResource resource = mpxmediaResourceAssembler.toResource(media);

        return response(resource, HttpStatus.OK);//new ResponseEntity<>(resource, HttpStatus.OK);
    }



    private MediaEntry getMpxMediaById(String mediaId) throws ResourceNotFoundException {
        MediaEntry mediaEntry = mpxMediaEntryRepository.findOne(Long.valueOf(mediaId));//this.mediaEntryRepository.getMediaById(mediaId.substring(mediaId.lastIndexOf("=") + 1, mediaId.length()));
        if (mediaEntry == null /*|| !blogPost.isPublished()*/) {
            throw new ResourceNotFoundException("No Media Obejct with the id: "+mediaId);
        }
        return mediaEntry;
    }

    /**
     * Returns JSON resource. All media objects
     * */
    @RequestMapping(value = "/media",method = RequestMethod.GET)
    public HttpEntity<List<MediaEntry>> getMediaList() {

        List<MediaEntry> media = mpxMediaEntryRepository.findAll();

        //mediaEntryRepository.getMediaList();

        return response(media, HttpStatus.OK);//new ResponseEntity<>(media, HttpStatus.OK);
    }

    /**
     * Returns public media by id. JSON only
     *
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/media/{id}",method = RequestMethod.GET)
    public HttpEntity<MediaEntry> getMediaByID(@PathVariable("id") String id)
            throws ResourceNotFoundException {

        MediaEntry media = mpxMediaEntryRepository.findOne(Long.valueOf(id));
        //getMpxMediaById(id);

        return response(media, HttpStatus.OK);//new ResponseEntity<>(resource, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> response(T body, HttpStatus status) {
        return new ResponseEntity<T>(body, status);
    }

}
