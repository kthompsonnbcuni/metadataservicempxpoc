package hello.repository;


import hello.model.MediaEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by kenville on 5/27/2015.
 */
public interface MpxMediaEntryRepositoryCustom {
    //public Page<SearchHit<MediaEntry>> findByQuery(String queryString, String filterQueryString, Pageable pageable);

    public Page<MediaEntry> findAll(String filterQueryString, Pageable pageable);
}
