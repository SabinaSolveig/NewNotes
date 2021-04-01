package com.example.myappnotes.screens.main;

import androidx.lifecycle.LiveData;

import com.example.myappnotes.App;
import com.example.myappnotes.model.Note;

import java.util.List;

public class MainFragmentViewModel {
    private final LiveData<List<Note>> noteLiveData = App.getInstance().getNoteDao().getAllLiveData();
    public LiveData<List<Note>> getNoteLiveData() {
        return noteLiveData;
    }
}
