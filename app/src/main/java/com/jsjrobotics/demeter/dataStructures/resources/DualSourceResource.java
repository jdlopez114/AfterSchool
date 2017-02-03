package com.jsjrobotics.demeter.dataStructures.resources;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public interface DualSourceResource {
    String getFilename();
    String getUrl();
    void getContent(Receiver<Optional<DisplayableScreen>> listener);
    void loadOnlineContent(Receiver<Optional<DisplayableScreen>> listener);
    Optional<DisplayableScreen> loadOfflineContent();
}
