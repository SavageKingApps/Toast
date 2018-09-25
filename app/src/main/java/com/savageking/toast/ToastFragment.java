package com.savageking.toast;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ToastFragment extends Fragment {

    private final static String TAG = "ToastFragment";

    private View.OnClickListener buttonClick;
    private View.OnClickListener toolBarClick;

    public static ToastFragment getInstance()
    {
        return new ToastFragment();
    }

    public static String getInstanceTag()
    {
        return TAG;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //shows the toast!
                Toast.makeText( v.getContext(), R.string.toast_text, Toast.LENGTH_LONG ).show();
            }
        };

        toolBarClick = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_toast, container, false);

        //get the toolbar
        final Toolbar toolBar = view.findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.toolbar_title);
        toolBar.setSubtitle(R.string.toolbar_subtitle);
        toolBar.setNavigationIcon( R.drawable.ic_clear_mtrl_alpha );
        toolBar.setNavigationOnClickListener( toolBarClick );

        //get the button
        final Button button = view.findViewById(R.id.button);
        button.setOnClickListener( buttonClick);

        return view;
    }
}
