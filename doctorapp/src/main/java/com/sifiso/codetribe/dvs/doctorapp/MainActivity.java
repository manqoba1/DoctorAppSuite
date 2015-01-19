package com.sifiso.codetribe.dvs.doctorapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.sifiso.codetribe.dvs.doctorapp.fragment.PatientFragment;
import com.sifiso.codetribe.dvs.doctorapp.fragment.VisitFragment;
import com.sifiso.codetribe.dvs.doctorlib.adapter.PagerAdapter;
import com.sifiso.codetribe.dvs.doctorlib.dto.PatientfileDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.RequestDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.ResponseDTO;
import com.sifiso.codetribe.dvs.doctorlib.dto.VisitDTO;
import com.sifiso.codetribe.dvs.doctorlib.toolbox.BaseVolley;
import com.sifiso.codetribe.dvs.doctorlib.util.Statics;
import com.sifiso.codetribe.dvs.doctorlib.util.ToastUtil;
import com.sifiso.codetribe.dvs.doctorlib.util.WebSocketUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements PatientFragment.OnFragmentInteractionListener, VisitFragment.OnFragmentInteractionListener {
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sifiso.codetribe.dvs.doctorlib.R.layout.activity_main);
        ctx = getApplicationContext();
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mPager = (ViewPager) findViewById(com.sifiso.codetribe.dvs.doctorlib.R.id.pager);
        refresh = getIntent().getBooleanExtra("refresh", false);
        if (savedInstanceState != null) {
            response = (ResponseDTO) savedInstanceState
                    .getSerializable("response");
            if (response != null) {
                Log.i("MainPagerActivity", "restored instance state, fragments to be set");
                build();
            }
        }
    }

    private int doctorID;
    boolean refresh;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.sifiso.codetribe.dvs.doctorlib.R.menu.main, menu);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        doctorID = sp.getInt("doctorID", 0);
        if (refresh) {
            getDoctorData(doctorID);
            return true;
        }

        getDoctorData(doctorID);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == com.sifiso.codetribe.dvs.doctorlib.R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Gson gson = new Gson();

    @Override
    public void onSaveInstanceState(Bundle b) {
        Log.i("MainPagerActivity", "onSaveInstanceState");
        b.putSerializable("response", response);
        super.onSaveInstanceState(b);
    }

    private void build() {
        fragmentList = new ArrayList<Fragment>();
        Bundle data = new Bundle();
        data.putSerializable("response", response);
        Log.i("Response", gson.toJson(response));

        visitFragment = new VisitFragment();
        visitFragment.setArguments(data);

        patientFragment = new PatientFragment();
        patientFragment.setArguments(data);
        fragmentList.add(patientFragment);
        fragmentList.add(visitFragment);


        initializeAdapter();
    }

    private void initializeAdapter() {
        adapter = new PagerAdapter(getSupportFragmentManager(), fragmentList);

        mPager.setAdapter(adapter);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                currentPageIndex = arg0;

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public void setRefreshActionButtonState(final boolean refreshing) {
        if (mMenu != null) {
            final MenuItem refreshItem = mMenu.findItem(com.sifiso.codetribe.dvs.doctorlib.R.id.action_refresh);
            if (refreshItem != null) {
                if (refreshing) {
                    refreshItem.setActionView(com.sifiso.codetribe.dvs.doctorlib.R.layout.action_bar_progess);
                } else {
                    refreshItem.setActionView(null);
                }
            }
        }
    }

    private void getDoctorData(int doctorID) {
        RequestDTO w = new RequestDTO();
        w.setRequestType(RequestDTO.GET_DOCTOR_DATA);
        w.setDoctorID(doctorID);


        if (!BaseVolley.checkNetworkOnDevice(ctx)) {
            return;
        }
        setRefreshActionButtonState(true);
        WebSocketUtil.sendRequest(ctx, Statics.DVS_ENDPOINT, w, new WebSocketUtil.WebSocketListener() {
            @Override
            public void onMessage(final ResponseDTO r) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        response = r;
                        setRefreshActionButtonState(false);
                        build();

                    }
                });

            }

            @Override
            public void onClose() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setRefreshActionButtonState(false);
                        ToastUtil.errorToast(ctx, "Please Check Your Network Connectivity");
                    }
                });
            }

            @Override
            public void onError(final String message) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setRefreshActionButtonState(false);
                        ToastUtil.errorToast(ctx, message);
                    }
                });
            }
        });
    }

    ViewPager mPager;
    PagerTitleStrip pagerTitleStrip;
    Menu mMenu;
    ResponseDTO response;
    int currentPageIndex;
    PagerAdapter adapter;
    private List<Fragment> fragmentList;
    Context ctx;

    VisitFragment visitFragment;
    PatientFragment patientFragment;

    @Override
    public void onFragmentInteraction(VisitDTO uri) {

    }

    @Override
    public void onFragmentInteraction(PatientfileDTO uri) {

    }
}
