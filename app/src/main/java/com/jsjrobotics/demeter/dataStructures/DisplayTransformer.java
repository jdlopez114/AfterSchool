package com.jsjrobotics.demeter.dataStructures;

public interface DisplayTransformer<T> {
    Class<T> getTransformToType();
    void apply(T item);
}
