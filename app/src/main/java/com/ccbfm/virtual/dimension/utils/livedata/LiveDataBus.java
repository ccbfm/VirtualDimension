package com.ccbfm.virtual.dimension.utils.livedata;

import androidx.lifecycle.MutableLiveData;

public final class LiveDataBus extends HashMapMode<String, MutableLiveData<?>> {

    private LiveDataBus() {
        super();
    }

    @SuppressWarnings("unchecked")
    public <T> MutableLiveData<T> with(String key) {
        return (MutableLiveData<T>) getValue(key);
    }

    private static class SingleTonHolder {
        private final static LiveDataBus INSTANCE = new LiveDataBus();
    }

    public static LiveDataBus get() {
        return SingleTonHolder.INSTANCE;
    }


    @Override
    protected MutableLiveData<?> createValue() {
        return new MutableLiveData<>();
    }

    public static <T> void changeData(String key, T data) {
        LiveDataBus.get().<T>with(key)
                .postValue(data);
    }
}