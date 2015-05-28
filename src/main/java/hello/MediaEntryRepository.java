package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.model.Media;
import hello.model.MediaEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class MediaEntryRepository {



    @Autowired
    private ResourceLoader resourceLoader;
    //@Autowired
    //private ResourceLoader resourceLoader2;

    private File myFile;

    private File myFile2;

    @PostConstruct
    private void init() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:MediaEntries.json");
        if (resource != null) {
            myFile = resource.getFile();
        }

    }


    public MediaEntry getMediaById(String id) {
        final ObjectMapper mapper = new ObjectMapper();
        Media readValues = null;
        MediaEntry readValue=null;
        try {
            readValues = mapper.readValue(myFile, Media.class);
            //System.out.println("ID Param is: "+id);
            for (MediaEntry m: readValues.getEntries()) {
                //System.out.println("ID: " + m.getIdUri());
                if ( m.getIdUri().equalsIgnoreCase(id)) {
                    //System.out.println("ID Found is: " + m.getIdUri());
                    readValue = m;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readValue;

    }

    //@Override
    public Page<MediaEntry> getAllMedia(Pageable pageable) {
        final ObjectMapper mapper = new ObjectMapper();
        Media readValues = null;
        Page<MediaEntry> searchResults = null;//mediaRepository.findAll(pageable);
        try {
            readValues = mapper.readValue(myFile, Media.class);
            searchResults = new PageImpl<MediaEntry>(readValues.getEntries(), pageable,2);
            //(Page<MediaEntry>) readValues.getEntries();
            //mapper.readValue(myFile,Media.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //searchResults = mediaRepository.findAll();

        return searchResults;//new PageImpl<>(searchResults, pageable,1);
    }

    public List<MediaEntry> getMediaList()
    {
        final ObjectMapper mapper = new ObjectMapper();
        Media readValues = null;

        List<MediaEntry> searchResults = null;//mediaRepository.findAll(pageable);
        try {
            readValues = mapper.readValue(myFile, Media.class);
            searchResults = readValues.getEntries();

        } catch (IOException e) {
            e.printStackTrace();
        }



        return searchResults;

    }
//    @Override
//    public List<MpxNotificationInfo> getNotifications(Long sequence) {
//        return null;
//    }
}
