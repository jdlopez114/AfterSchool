package com.example.jello.afterschool;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.DualSourceResource;

public abstract class DefaultModel {

    protected static void loadContent(final DualSourceResource resource,
                                    final Receiver<Optional<DisplayableScreen>> listener) {
        Thread t = new Thread(() -> {
            resource.getContent(listener);
        });
        t.start();
    }
}
