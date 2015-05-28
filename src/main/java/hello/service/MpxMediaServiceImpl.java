package hello.service;


import hello.model.MediaEntry;
import hello.repository.MpxMediaEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.nbcuni.naturalmpx.model.notification.MpxMediaNotificationInfo;
//import com.nbcuni.naturalmpx.repository.MpxMediaNotificationInfoRepository;

@Service
public class MpxMediaServiceImpl implements MpxMediaService {

//    @Autowired
//    @Qualifier("mediaIngestService")
//    private MediaIngestService mediaIngestService;

//    @Autowired
//    private NotificationIngestService notificationIngestService;

    @Autowired
    private MpxMediaEntryRepository MpxMediaEntryRepository;

//    @Autowired
//    private MpxMediaNotificationInfoRepository mpxMediaNotificationInfoRepository;


//    @Value("${mpx.media.id}")
//    private String mediaId;

    @Override
    public List<MediaEntry> getMedia() {

        return MpxMediaEntryRepository.findAll();
    }

    @Override
    public MediaEntry getMediaEntry(String Id) {
        return MpxMediaEntryRepository.findOne(Long.valueOf(Id));
    }


}