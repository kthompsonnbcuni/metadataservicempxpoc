/* 
 * Copyright 2013-2015 JIWHIZ Consulting Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello.resource;

import hello.MediaController;
import hello.ResourceNotFoundException;
import hello.model.MediaEntry;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class MpxMediaResourceAssembler implements ResourceAssembler<MediaEntry, MpxMediaResource> {

    org.springframework.data.web.PagedResourcesAssembler<MediaEntry> assembler;
   // hello.resource.PagedResourcesAssembler<MediaEntry> assembler;
    
    @Inject
    public MpxMediaResourceAssembler(org.springframework.data.web.PagedResourcesAssembler<MediaEntry> assembler) {
        this.assembler = assembler;
        //super(MediaController.class, MpxMediaResource.class);
    }
    
    @Override
    public MpxMediaResource toResource(MediaEntry mediaEntry) {
        MpxMediaResource resource = new MpxMediaResource(mediaEntry);
        
        try {
            resource.add(linkTo(methodOn(MediaController.class).getMediaById(mediaEntry.getMediaId().toString()))
                    .withSelfRel());
            //resource.add(assembler.appendPaginationParameterTemplates(commentsLink));
            //resource.add(linkTo(methodOn(UserRestController.class).getUserAccountByUserId(blogPost.getAuthorId()))
              //      .withRel(BlogResource.LINK_NAME_AUTHOR));

            //Link commentsLink = linkTo(methodOn(MediaController.class)
            //        .getCommentPostsByBlogPostId(blogPost.getId(), null, null))
             //       .withRel(BlogResource.LINK_NAME_COMMENTS);
            //resource.add(assembler.appendPaginationParameterTemplates(commentsLink));

        } catch (ResourceNotFoundException ex) {
            //do nothing
        }
        return resource;
    }

}
