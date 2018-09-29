package com.savageking.toast;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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

    private View.OnClickListener buttonToastClick;
    private View.OnClickListener buttonSnackClick;
    private View.OnClickListener toolBarClick;

    private Snackbar snackbar;
    private View.OnClickListener snackbarActionClick;

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

        buttonToastClick = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //shows the toast!
                Toast.makeText( v.getContext(), R.string.toast_text, Toast.LENGTH_LONG ).show();
            }
        };

        buttonSnackClick = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!snackbar.isShown())
                    snackbar.show();
            }
        };

        snackbarActionClick = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(snackbar.isShown())
                    snackbar.dismiss();
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
        final Button buttonToast = view.findViewById(R.id.button_toast);
        buttonToast.setOnClickListener( buttonToastClick);

        final Button buttonSnack = view.findViewById(R.id.button_snackbar);
        buttonSnack.setOnClickListener( buttonSnackClick);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        snackbar = Snackbar.make( getView(), R.string.snackbar_text, Snackbar.LENGTH_INDEFINITE );
        snackbar.setAction( R.string.snackbar_action, snackbarActionClick );
        snackbar.setActionTextColor(Color.RED);
    }
}
