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
import androidx.navigation.Navigation;

import com.example.toolsbox.CompassActivity;
import com.example.toolsbox.InquiryActivity;
import com.example.toolsbox.QrActivity;
import com.example.toolsbox.R;
import com.example.toolsbox.VideoActivity;
import com.example.toolsbox.WebActivity;
import com.example.toolsbox.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment implements View.OnClickListener{

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private Button QR_generation_button;
    private Button compass_button;
    private Button video_button;
    private Button inquiry_button;
    private Button web_button;
//    private FragmentManager manager;
//    private FragmentTransaction ft;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.btnTools;
        QR_generation_button = binding.QRButton;
        compass_button = binding.compassButton;
        video_button = binding.videoButton;
        inquiry_button = binding.inquiryButton;
        web_button = binding.webButton;
        QR_generation_button.setOnClickListener(this);
        compass_button.setOnClickListener(this);
        video_button.setOnClickListener(this);
        inquiry_button.setOnClickListener(this);
        web_button.setOnClickListener(this);


//        QR_generation_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                manager = getFragmentManager();
////                QRCodeFragment qrCodeFragment = new QRCodeFragment();
////                ft = manager.beginTransaction();
////                ft.replace(R.id.nav_gallery,qrCodeFragment);
////                ft.addToBackStack(null);
////                ft.commit();
////                Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_nav_qr);
//                Intent intent = new Intent(getActivity(), QrActivity.class);
//                startActivity(intent);
//
//
//
//            }
//        });
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.QR_button:
                Intent intent = new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
                break;
            case R.id.compass_button:
                Intent intent1 = new Intent(getActivity(), CompassActivity.class);
                startActivity(intent1);
                break;
            case R.id.video_button:
                Intent intent2 = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent2);
                break;
            case R.id.inquiry_button:
                Intent intent3 = new Intent(getActivity(), InquiryActivity.class);
                startActivity(intent3);
                break;
            case R.id.web_button:
                Intent intent4 = new Intent(getActivity(), WebActivity.class);
                startActivity(intent4);
                break;
            default:
                break;

        }

    }
}