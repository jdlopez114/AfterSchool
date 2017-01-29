package com.jsjrobotics.demeter.androidWrappers;

import android.os.Bundle;
import android.view.View;

public interface DefaultView {
    View getLayout();
    void setLoading(boolean isLoading);
    void setError(boolean displayErrorScreen);
}