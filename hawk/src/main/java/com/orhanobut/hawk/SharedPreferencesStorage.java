package com.orhanobut.hawk;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Orhan Obut
 */
final class SharedPreferencesStorage implements Storage {

    private final SharedPreferences preferences;

    SharedPreferencesStorage(Context context, String tag) {
        preferences = context.getSharedPreferences(tag, Context.MODE_PRIVATE);
    }

    @Override
    public <T> boolean put(String key, T value) {
        return getEditor().putString(key, String.valueOf(value)).commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String key) {
        return (T) preferences.getString(key, null);
    }

    @Override
    public boolean remove(String key) {
        return getEditor().remove(key).commit();
    }

    @Override
    public boolean contains(String key) {
        return preferences.contains(key);
    }

    @Override
    public boolean clear() {
        return getEditor().clear().commit();
    }

    @Override
    public int count() {
        return preferences.getAll().size();
    }

    private SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }

}
