package com.jsjrobotics.demeter.dataStructures;

import com.jsjrobotics.demeter.utils.BitmapInflater;

import java.util.List;

public class DisplayableScreen {
    protected final List<DisplayItem> mContent;

    protected DisplayableScreen (List<DisplayItem> content) {
        mContent = content;
    }
    public List<DisplayItem> getContent() {
        return mContent;
    }
}
