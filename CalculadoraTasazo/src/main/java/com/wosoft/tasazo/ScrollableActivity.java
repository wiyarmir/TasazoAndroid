package com.wosoft.tasazo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ScrollableActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scrollable, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent i = new Intent(ScrollableActivity.this, AboutActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a SectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new SectionFragment();
            Bundle args = new Bundle();
            args.putInt(SectionFragment.ARG_SECTION_NUMBER, position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public class SectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";
        private int sectionNumber = -1;
        private Button bSpinner;
        private int careerGroup = -1;
        private AlertDialog diag = null;
        private Button bCalcular;
        private EditText tCredits1;
        private EditText tCredits2;
        private EditText tCredits3;
        private EditText tCredits4;
        private float fCredits1;
        private float fCredits2;
        private float fCredits3;
        private float fCredits4;

        public SectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER, -1);


            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Grupo");

            ScrollView rootlayout = new ScrollView(getActivity());
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            String[][] careers = {
                    getResources().getStringArray(R.array.careers_array_1),
                    getResources().getStringArray(R.array.careers_array_2),
                    getResources().getStringArray(R.array.careers_array_3),
                    getResources().getStringArray(R.array.careers_array_4),
                    getResources().getStringArray(R.array.careers_array_5)
            };

            String[] headers = getResources().getStringArray(R.array.careers_headers);
            int i = 0;
            LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            for (String[] group : careers) {
                TextView grouphead = (TextView) layoutInflater.inflate(R.layout.careers_list_header, null);
                grouphead.setText(headers[i++]);

                layout.addView(grouphead, params);
                for (final String item : group) {
                    TextView it = (TextView) layoutInflater.inflate(R.layout.careers_list_button, null);
                    it.setText(item);
                    final int a = i;
                    it.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onDialogFinished(item, a);
                        }
                    });
                    layout.addView(it);
                }
            }


            rootlayout.addView(layout);
            builder.setView(rootlayout);

            diag = builder.create();
            View rootView = inflater.inflate(R.layout.fragment_scrollable, container, false);
            bSpinner = (Button) rootView.findViewById(R.id.spinner_group);
            bSpinner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diag.show();
                }
            });


            tCredits1 = (EditText) rootView.findViewById(R.id.editText1);
            tCredits2 = (EditText) rootView.findViewById(R.id.editText2);
            tCredits3 = (EditText) rootView.findViewById(R.id.editText3);
            tCredits4 = (EditText) rootView.findViewById(R.id.editText4);

            bCalcular = (Button) rootView.findViewById(R.id.button);
            bCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (performDataCheck()) {

                        Intent i = new Intent(ScrollableActivity.this, ResultsActivity.class);
                        i.putExtra("section", sectionNumber);
                        i.putExtra("careerGroup", careerGroup);
                        i.putExtra("credits1", fCredits1);
                        i.putExtra("credits2", fCredits2);
                        i.putExtra("credits3", fCredits3);
                        i.putExtra("credits4", fCredits4);
                        startActivity(i);

                    }
                }
            });

            return rootView;
        }

        @Override
        public void onDestroy() {
            if (diag != null) {
                diag.dismiss();
            }
            super.onDestroy();
        }

        private boolean performDataCheck() {
            if (tCredits1.getText().length() == 0) {
                tCredits1.setText("0");
            }
            if (tCredits2.getText().length() == 0) {
                tCredits2.setText("0");
            }
            if (tCredits3.getText().length() == 0) {
                tCredits3.setText("0");
            }
            if (tCredits4.getText().length() == 0) {
                tCredits4.setText("0");
            }
            try {
                fCredits1 = Float.parseFloat(tCredits1.getText().toString());
                fCredits2 = Float.parseFloat(tCredits2.getText().toString());
                fCredits3 = Float.parseFloat(tCredits3.getText().toString());
                fCredits4 = Float.parseFloat(tCredits4.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), R.string.invalid_data, Toast.LENGTH_SHORT).show();
                return false;
            }

            if (fCredits1 < 0 || fCredits2 < 0 || fCredits3 < 0 || fCredits4 < 0) {
                Toast.makeText(getActivity(), R.string.invalid_data, Toast.LENGTH_SHORT).show();
                return false;
            }

            if (careerGroup < 0) {
                Toast.makeText(getActivity(), R.string.invalid_careergroup, Toast.LENGTH_SHORT).show();
                return false;
            }

            return true;
        }

        public void onDialogFinished(String careerName, int groupNumber) {
            bSpinner.setText(careerName);
            careerGroup = groupNumber;
            diag.hide();
        }


    }


}
