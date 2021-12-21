package com.example.toolsbox.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.toolsbox.R;
import com.example.toolsbox.databinding.FragmentGalleryBinding;
import com.example.toolsbox.ui.QR_generation.QRCodeFragment;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private Button QR_generation_button;
    private FragmentManager manager;
    private FragmentTransaction ft;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.btnTools;
        QR_generation_button = binding.QRButton;
        QR_generation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = getFragmentManager();
                QRCodeFragment qrCodeFragment = new QRCodeFragment();
                ft = manager.beginTransaction();
                ft.replace(R.id.nav_gallery,qrCodeFragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}