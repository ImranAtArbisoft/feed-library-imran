package com.arbisoft.sentimetersdk.communication;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by Imran on 7/28/2016.
 * Used to exclude specific fields or classes from GSON conversion
 */
public class MyExclusionStrategy implements ExclusionStrategy {
    private final Class<?> typeToSkip;

    public MyExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(ExcludedField.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }
}
