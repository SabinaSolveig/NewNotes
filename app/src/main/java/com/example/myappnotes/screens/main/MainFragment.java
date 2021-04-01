package com.example.myappnotes.screens.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myappnotes.R;
import com.example.myappnotes.model.Note;
import com.example.myappnotes.screens.details.NoteDetailsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    private RecyclerView recyclerView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(view -> NoteDetailsActivity.start(MainActivity.this, null));

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getNoteLiveData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setItems(notes);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }


}