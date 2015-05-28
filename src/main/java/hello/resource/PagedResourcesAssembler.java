package hello.resource;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.hateoas.*;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.util.Assert;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromUri;

//@Component
public class PagedResourcesAssembler<T> implements ResourceAssembler<Page<T>, PagedResources<Resource<T>>> {

    private static final boolean INCLUDE_CURIE = true;

    public static final String SELF_TITLE = "This collection";
    public static final String FIRST_TITLE = "First page of this collection";
    public static final String PREVIOUS_TITLE = "Previous page of this collection";
    public static final String NEXT_TITLE = "Next page of this collection";
    public static final String LAST_TITLE = "Last page of this collection";


    private final HateoasPageableHandlerMethodArgumentResolver pageableResolver;
    private final UriComponents baseUri;
    private final boolean oneBasedPageNumberIndex;

    public PagedResourcesAssembler()
    {
        this.pageableResolver = null;
        this.baseUri = null;
        this.oneBasedPageNumberIndex = false;
    }
    public PagedResourcesAssembler(HateoasPageableHandlerMethodArgumentResolver resolver, UriComponents baseUri,
                                   boolean oneBasedPageNumberIndex) {
        this.pageableResolver = resolver == null ? new HateoasPageableHandlerMethodArgumentResolver() : resolver;
        this.baseUri = baseUri;
        this.oneBasedPageNumberIndex = oneBasedPageNumberIndex;
    }



    @Override
    public PagedResources<Resource<T>> toResource(Page<T> entity) {
        return toResource(entity, new SimplePagedResourceAssembler<T>());
    }

    public PagedResources<Resource<T>> toResource(Page<T> page, Link selfLink) {
        return toResource(page, new SimplePagedResourceAssembler<T>(), selfLink);
    }

    public <R extends ResourceSupport> PagedResources<R> toResource(Page<T> page, ResourceAssembler<T, R> assembler) {
        return createResource(page, assembler, null);
    }

    public <R extends ResourceSupport> PagedResources<R> toResource(Page<T> page, ResourceAssembler<T, R> assembler,
                                                                    Link link) {
        Assert.notNull(link, "Link must not be null!");
        return createResource(page, assembler, link);
    }

    private <S, R extends ResourceSupport> PagedResources<R> createResource(Page<S> page,
                                                                            ResourceAssembler<S, R> assembler, Link link) {
        Assert.notNull(page, "Page must not be null!");
        Assert.notNull(assembler, "ResourceAssembler must not be null!");

        List<R> resources = new ArrayList<R>(page.getNumberOfElements());

        for (S element : page) {
            resources.add(assembler.toResource(element));
        }

        UriTemplate base = new UriTemplate(link == null ? getDefaultUriString() : link.getHref());

        PagedResources<R> pagedResources = new PagedResources<R>(resources, asPageMetadata(page));

        pagedResources.add(createLinkWithoutVariables(base, currentPageable(page), Link.REL_SELF, SELF_TITLE));

        if (!page.isFirst()) {
            pagedResources.add(createLink(base, firstPageable(page), Link.REL_FIRST, FIRST_TITLE));
        }

        if (page.hasNext()) {
            pagedResources.add(createLink(base, page.nextPageable(), Link.REL_NEXT, NEXT_TITLE));
        }

        if (page.hasPrevious()) {
            pagedResources.add(createLink(base, page.previousPageable(), Link.REL_PREVIOUS, PREVIOUS_TITLE));
        }

        if (!page.isLast()) {
            pagedResources.add(createLink(base, lastPageable(page), Link.REL_LAST, LAST_TITLE));
        }

        return pagedResources;
    }

    private String getDefaultUriString() {
        return baseUri == null ? ServletUriComponentsBuilder.fromCurrentRequest().build().toString() : baseUri
                .toString();
    }

    private Link createLink(UriTemplate base, Pageable pageable, String rel, String title) {
        UriComponentsBuilder builder = fromUri(base.expand());
        pageableResolver.enhance(builder, getMethodParameter(), pageable);

        UriComponents components = builder.build();
        TemplateVariables variables = new TemplateVariables(base.getVariables());
        variables = variables.concat(pageableResolver.getPaginationTemplateVariables(getMethodParameter(), components));

        return new ResourceLinkBuilder.Builder()
                .template(new UriTemplate(components.toString()).with(variables))
                .rel(rel)
                .title(title)
                .build();
    }

    private Link createLinkWithoutVariables(UriTemplate base, Pageable pageable, String rel, String title) {

        UriComponentsBuilder builder = fromUri(base.expand());
        pageableResolver.enhance(builder, getMethodParameter(), pageable);

        UriComponents components = builder.build();

        return new ResourceLinkBuilder.Builder()
                .template(new UriTemplate(components.toString()))
                .rel(rel)
                .title(title)
                .build();
    }

    protected MethodParameter getMethodParameter() {
        return null;
    }

    private Pageable currentPageable(Page page) {
        return new PageRequest(page.getNumber(), page.getSize(), page.getSort());
    }

    private Pageable firstPageable(Page page) {
        return new PageRequest(0, page.getSize(), page.getSort());
    }

    private Pageable lastPageable(Page page) {
        return new PageRequest(page.getTotalPages() - 1, page.getSize(), page.getSort());
    }

    private <T> PageMetadata asPageMetadata(Page<T> page) {
        Assert.notNull(page, "Page must not be null!");
        return new PageMetadata(page.getSize(),
                oneBasedPageNumberIndex ? page.getNumber() + 1 : page.getNumber(),
                page.getTotalElements(),
                page.getTotalPages());
    }

    private static class SimplePagedResourceAssembler<T> implements ResourceAssembler<T, Resource<T>> {

        @Override
        public Resource<T> toResource(T entity) {
            return new Resource<T>(entity);
        }
    }
}
