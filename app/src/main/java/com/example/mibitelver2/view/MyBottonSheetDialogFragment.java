package com.example.mibitelver2.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mibitelver2.R;
import com.example.mibitelver2.view.adapter.CommentAdapter;
import com.example.mibitelver2.databinding.LayoutBottomSheetFragmentBinding;
import com.example.mibitelver2.model.Comment;
import com.example.mibitelver2.view.viewmodel.CommentViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class MyBottonSheetDialogFragment extends BottomSheetDialogFragment {
    private CommentViewModel commentViewModel;
    LayoutBottomSheetFragmentBinding layoutBottomSheetFragmentBinding;

    public static MyBottonSheetDialogFragment newInstance() {
        MyBottonSheetDialogFragment myBottonSheetDialogFragment = new MyBottonSheetDialogFragment();

        return myBottonSheetDialogFragment;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialogTheme);

        layoutBottomSheetFragmentBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_bottom_sheet_fragment, null, false);
        commentViewModel = new ViewModelProvider(requireActivity()).get(CommentViewModel.class);
        commentViewModel.getListComment();

        bottomSheetDialog.setContentView(layoutBottomSheetFragmentBinding.getRoot());


        change();
        return bottomSheetDialog;

    }

    private void change() {
        commentViewModel.commentListMu.observe(this, comment -> setRecyclerView(commentViewModel.getComment()));
    }

    private void setRecyclerView(List<Comment> list) {
        layoutBottomSheetFragmentBinding.setAdapter(new CommentAdapter(getContext(), list));
    }

    private void setPostComment() {

    }

}

