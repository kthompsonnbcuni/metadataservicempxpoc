package hello.repository;

import hello.model.MediaEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by kenville on 5/27/2015.
 */

@Repository
public class MpxMediaEntryRepositoryImpl implements MpxMediaEntryRepositoryCustom{

    @Override
    public Page<MediaEntry> findAll(String filterQueryString, Pageable pageable) {

       System.out.println("Holding");

        return null;
    }
}
