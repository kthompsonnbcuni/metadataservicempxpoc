package hello.resource;

import hello.model.MediaEntry;
import org.springframework.hateoas.Resource;

/**
 * Created by kenville on 5/21/2015.
 */

public class MpxMediaResource extends Resource<MediaEntry> {
    //public static final String LINK_NAME_AUTHOR = "author";
    //public static final String LINK_NAME_COMMENTS = "comments";

    public MpxMediaResource(MediaEntry media) {
        super(media);
    }

}
