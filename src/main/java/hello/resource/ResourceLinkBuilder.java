package hello.resource;

//import com.nbcuni.news.contentwarehouse.api.controller.external.RootController;
//import com.nbcuni.news.contentwarehouse.api.controller.external.author.AuthorController;

import hello.MediaController;
import hello.MediaEntryRepository;
import hello.hateoas.hal.LinkRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ResourceLinkBuilder {

    private static final String ID_URL = "/{id}";
    //private static final String NAME_URL = "/{name}";
    private static final String SEARCH_BASE_URL = "/search?q={query}";

//    private static final String PUBLISHER_PROPERTY = "publisher";
//    private static final String PUBLISHER_NAME_PROPERTY = "name";
//    private static final String PUBLISHER_TITLE_PROPERTY = "title";
//    private static final String EXTERNAL_SOURCE_PROPERTY = "externalSource";
//    private static final String EXTERNAL_SOURCE_CURIE_PROPERTY = "curie";
//    private static final String PREFER_COLLECTIONS_TAGS_PROPERTY = "preferCollectionsTags";
//    private static final String PROPERTY_LIST_SEPARATOR = ",";
//    private static final String PROPERTY_SEPARATOR = ".";
//    private static final String CURIE_SEPARATOR = ":";

    //private static final FieldFilter NAME_FIELD_FILTER = new FieldFilter(new HashSet<>(
   //         asList(new String[] { NAME_FIELD })), false);

    private static final TemplateVariables PAGINATION_VARIABLES = new TemplateVariables(new TemplateVariable("page",
            VariableType.REQUEST_PARAM), new TemplateVariable("size", VariableType.REQUEST_PARAM),
            new TemplateVariable("sort", VariableType.REQUEST_PARAM));

    private static final TemplateVariables FILTERS_VARIABLE = new TemplateVariables(new TemplateVariable("filters", VariableType.REQUEST_PARAM));
//
//    private static final Map<String, Set<String>> PREFER_COLLECTIONS_TAGS = new HashMap<>();

    @Autowired
    private Environment env;

    @Autowired
    private MediaEntryRepository mediaEntryRepository;

    @PostConstruct
    public void init() {

        System.out.println("Init");
    }


//    public Link linkToMedia() {
//
//        return new Link.Builder().title("Get a media from its ID")
//                .template(new UriTemplate(linkTo(MediaController.class).withSelfRel().getHref() + ID_URL))
//                .rel(LinkRelation.media.name()).build();
//
//    }
//
//    public Link linkToMedias() {
//
//        return new Link.Builder()
//                .title("Get a paged collection of media")
//                .template(
//                        new UriTemplate(linkTo(MediaController.class).withSelfRel().getHref()).with(
//                                PAGINATION_VARIABLES)).rel(LinkRelation.medias.name()).build();
//
//    }


    public Link selfLinkToMedia(String id) {
        return linkTo(methodOn(MediaController.class).getMediaById(id)).withSelfRel();
    }


    public Link linkToMedias() {


        return new ResourceLinkBuilder.Builder()
                .title("Get a paged collection of media objects")
                .template(
                        new UriTemplate(linkTo(MediaController.class).withSelfRel().getHref()).with(
                                PAGINATION_VARIABLES)).rel(LinkRelation.medias.name()).build();

    }

    public static class Builder {
        private String rel;
        private String href;
        private String name;
        private String title;
        private UriTemplate template;
        private boolean preferCollections;

        public Builder() {
        }

        public ResourceLinkBuilder.Builder rel(String rel) {
            this.rel = rel;
            return this;
        }

        public ResourceLinkBuilder.Builder href(String href) {
            this.href = href;
            return this;
        }

        public ResourceLinkBuilder.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ResourceLinkBuilder.Builder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceLinkBuilder.Builder template(UriTemplate template) {
            this.template = template;
            return this;
        }

        public ResourceLinkBuilder.Builder preferCollections() {
            this.preferCollections = true;
            return this;
        }

        public Link build() {
            Link link = null;
            if(this.template != null) {
                link = new Link(this.template, this.rel);
            } else if(this.rel != null) {
                link = new Link(this.href, this.rel);
            } else {
                link = new Link(this.href);
            }

            //link.title = this.title;
            //link.name = this.name;
            //link.preferCollections = this.preferCollections;
            return link;
        }
    }
}
