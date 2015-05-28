package hello.resource;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static hello.resource.ResourcePropertyFilter.RESOURCE_FILTER_ID;

@JsonFilter(RESOURCE_FILTER_ID)
public abstract class AbstractResource extends ResourceSupport {

    public static final String LINKS_PROPERTY = "_links";
    public static final String EMBEDDED_PROPERTY = "_embedded";

    private static final EmbeddedWrappers EMBEDDED_WRAPPERS = new EmbeddedWrappers(false);

    @JsonIgnore
    private final List<EmbeddedWrapper> content = new ArrayList<>();

    @JsonUnwrapped
    @JsonProperty(EMBEDDED_PROPERTY)
    public Resources<EmbeddedWrapper> getResources() {
        return new Resources<>(content);
    }

    public void addResource(ResourceSupport resource, String relation, boolean preferCollection) {
        if (preferCollection) {
            if (resource != null) {
                this.content.add(EMBEDDED_WRAPPERS.wrap(Collections.singletonList(resource), relation));
            } else {
                this.content.add(EMBEDDED_WRAPPERS.wrap(Collections.emptyList(), relation));
            }
        } else {
            this.content.add(EMBEDDED_WRAPPERS.wrap(resource, relation));
        }
    }

    public void addResources(List<? extends ResourceSupport> resources, String relation) {
        if (CollectionUtils.isNotEmpty(resources)) {
            this.content.add(EMBEDDED_WRAPPERS.wrap(resources, relation));
        }
    }

    @Override
    public void add(Link link) {
        if (link != null) {
            super.add(link);
        }
    }

    @Override
    public void add(Iterable<Link> links) {
        if (links != null) {
            for (Link candidate : links) {
                add(candidate);
            }
        }
    }

    //@Override
    public void add(Link... links) {
        if (links != null) {
            add(Arrays.asList(links));
        }
    }

}
