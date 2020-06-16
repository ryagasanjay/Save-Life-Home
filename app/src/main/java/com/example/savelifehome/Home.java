package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    final View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.TestCenter:
                    Intent t = new Intent(getActivity(), TestCenter.class);
                    startActivity(t);
                    break;
                case R.id.Report:
                    Intent r = new Intent(getActivity(), Report.class);
                    startActivity(r);
                    break;
                case R.id.Volunteer:
                    Intent v = new Intent(getActivity(), Volunteer.class);
                    startActivity(v);
                    break;
                case R.id.News:
                    Intent n = new Intent(getActivity(), NewsOrAnnouncements.class);
                    startActivity(n);
                    break;
                case R.id.requestServices:
                    Intent rs = new Intent(getActivity(), EssentialServices.class);
                    startActivity(rs);
                    break;
                case R.id.ContactTracing:
                    startActivity(new Intent(getActivity(), ContactTracing.class));
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.TestCenter).setOnClickListener(mListener);
        view.findViewById(R.id.Volunteer).setOnClickListener(mListener);
        view.findViewById(R.id.News).setOnClickListener(mListener);
        view.findViewById(R.id.ContactTracing).setOnClickListener(mListener);
        view.findViewById(R.id.requestServices).setOnClickListener(mListener);
        view.findViewById(R.id.Report).setOnClickListener(mListener);


        //Inflate the layout for this fragment
        //  Button toTest = (Button) view.findViewById(R.id.TestCenter);
        // toTest.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //public void onClick(View view) {
        //Intent intent = new Intent(getActivity(), TestCenter.class);
        // startActivity(intent);

        //}
        //});

        return view;
    }
}