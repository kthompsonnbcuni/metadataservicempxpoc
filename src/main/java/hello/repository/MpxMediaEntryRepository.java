package hello.repository;

import hello.model.MediaEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MpxMediaEntryRepository extends MongoRepository<MediaEntry, Long>, MpxMediaEntryRepositoryCustom {
    //MediaEntry findById(String id);


}
