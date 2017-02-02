package com.jsjrobotics.demeter.dataStructures;

import com.jsjrobotics.demeter.utils.BitmapInflater;

import java.util.List;

public class DisplayableScreen {
    protected final BitmapInflater mImageInflater;
    protected final List<DisplayItem> mContent;

    protected DisplayableScreen (BitmapInflater inflater, List<DisplayItem> content) {
        mImageInflater = inflater;
        mContent = content;
    }

    public BitmapInflater getHeaderInflater() {
        return mImageInflater;
    }

    public List<DisplayItem> getContent() {
        return mContent;
    }
}
