package com.jsjrobotics.demeter.dataStructures.resources;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public abstract class OnlineFirstResource implements DualSourceResource {
    @Override
    public void getContent(Receiver<Optional<DisplayableScreen>> listener) {
        loadOnlineContent(onlineData -> {
            if (onlineData.isPresent()) {
                listener.accept(onlineData);
                return;
            }
            listener.accept(loadOfflineContent());
        });
    }
}
