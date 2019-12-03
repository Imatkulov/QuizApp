package com.geektech.quizapp.presentation.history;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.quizapp.R;
import com.geektech.quizapp.model.ShortQuizResult;
import com.geektech.quizapp.presentation.history.recycler.HistoryAdapter;

import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);
        initRecycler();
    }

    private void initRecycler() {
        historyAdapter = new HistoryAdapter();
        recyclerView.setAdapter(historyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mViewModel.listLiveData.observe(this, new Observer<List<ShortQuizResult>>() {
            @Override
            public void onChanged(List<ShortQuizResult> shortQuizResults) {
                historyAdapter.setHistorie(shortQuizResults);
            }
        });
    }
}
