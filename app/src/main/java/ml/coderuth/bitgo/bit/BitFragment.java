package ml.coderuth.bitgo.bit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ml.coderuth.bitgo.R;

public class BitFragment extends Fragment {

    private Toolbar toolbar;
    private int index;

    public BitFragment() { }

    public static BitFragment newInstance(int i) {
        BitFragment f = new BitFragment();
        Bundle args = new Bundle();
        args.putInt("INDEX", i);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bin, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) index = args.getInt("INDEX", 0);

        ViewCompat.setElevation(getView(), 10f);
        ViewCompat.setElevation(toolbar, 4f);

        toolbar.setTitle(BitAdapter.PAGE_TITLES[index]);
        toolbar.inflateMenu(R.menu.fragment);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

}
