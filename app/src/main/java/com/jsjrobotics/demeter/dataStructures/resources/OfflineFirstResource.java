package com.jsjrobotics.demeter.dataStructures.resources;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public abstract class OfflineFirstResource implements DualSourceResource {
    @Override
    public void getContent(Receiver<Optional<DisplayableScreen>> listener) {
        Optional<DisplayableScreen> offline = loadOfflineContent();
        if (offline.isPresent()) {
            listener.accept(offline);
            return;
        }
        loadOnlineContent(listener);
    }


}
