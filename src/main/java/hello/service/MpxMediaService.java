package hello.service;


import hello.model.MediaEntry;
//import com.nbcuni.naturalmpx.model.notification.MpxMediaNotificationInfo;

import java.util.List;

public interface MpxMediaService {

    public List<MediaEntry> getMedia();

    public MediaEntry getMediaEntry(String Id);

    //public List<MpxMediaNotificationInfo> saveMediaNotifications();
}
