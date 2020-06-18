package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Resources#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resources extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    final View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mhealth:
                    Intent intent = new Intent(getActivity(), Mental_health.class);
                    startActivity(intent);
                    break;
                case R.id.precaution:
                    intent = new Intent(getActivity(), Precaution.class);
                    startActivity(intent);
                    break;
                case R.id.usick:
                    intent = new Intent(getActivity(), Ifgetsick.class);
                    startActivity(intent);
                    break;
                case R.id.aboutcorona:
                    intent = new Intent(getActivity(), Covid_track.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Resources() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Resources.
     */
    // TODO: Rename and change types and number of parameters
    public static Resources newInstance(String param1, String param2) {
        Resources fragment = new Resources();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private ListView mlistView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
//
    }

//


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_resources, container, false);
        view.findViewById(R.id.precaution).setOnClickListener(mListener);
        view.findViewById(R.id.mhealth).setOnClickListener(mListener);
        view.findViewById(R.id.aboutcorona).setOnClickListener(mListener);
        view.findViewById(R.id.usick).setOnClickListener(mListener);


        return view;
    }
//

}