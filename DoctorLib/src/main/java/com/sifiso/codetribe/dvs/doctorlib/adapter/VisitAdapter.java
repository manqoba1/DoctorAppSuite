package com.sifiso.codetribe.dvs.doctorlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sifiso.codetribe.dvs.doctorlib.R;
import com.sifiso.codetribe.dvs.doctorlib.dto.VisitDTO;
import com.sifiso.codetribe.dvs.doctorlib.util.Util;

import java.util.Date;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class VisitAdapter extends ArrayAdapter<VisitDTO> {


    public interface VisitAdapterListener {
        public void onVisitData(VisitDTO visit);
    }

    private final LayoutInflater mInflater;
    private final int mLayoutRes;
    private List<VisitDTO> mList;
    private Context ctx;
    private VisitAdapterListener listener;

    static class Holder {
        TextView VV_count, VV_status, VV_name, VV_stnd_no,
                VV_receptionist;
    }

    public VisitAdapter(Context context, int resource, List<VisitDTO> list, VisitAdapterListener listener) {
        super(context, resource, list);
        this.mLayoutRes = resource;
        mList = list;
        this.listener = listener;
        ctx = context;
        this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    Holder h;

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        h = new Holder();
        if (v == null) {
            v = mInflater.inflate(mLayoutRes, null);
            h.VV_count = (TextView) v.findViewById(R.id.VV_count);
            h.VV_name = (TextView) v.findViewById(R.id.VV_name);
            h.VV_status = (TextView) v.findViewById(R.id.VV_status);
            h.VV_receptionist = (TextView) v.findViewById(R.id.VV_receptionist);
            h.VV_stnd_no = (TextView) v.findViewById(R.id.VV_stnd_no);
            v.setTag(h);
        } else {
            h = (Holder) v.getTag();
        }
        final VisitDTO dto = mList.get(position);

        h.VV_name.setText(dto.getPatientfile().getClient().getSurname() + ", " +
                dto.getPatientfile().getClient().getName());


        if (dto.getFlag() == 0) {
            h.VV_status.setText("Attended");
            h.VV_status.setTextColor(v.getResources().getColor(R.color.green));
        } else {
            h.VV_status.setText("Pending");
            h.VV_status.setTextColor(v.getResources().getColor(R.color.absa_red));
        }
        h.VV_stnd_no.setText(dto.getPatientfile().getClient().getStandNumber());
        h.VV_receptionist.setText(dto.getReceptionist().getSurname() + ", " + dto.getReceptionist().getName());
        h.VV_count.setText("" + (position + 1));
        animateView(v);
        return v;
    }

    public void animateView(final View view) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.grow_fade_in_center);
        a.setDuration(2500);
        if (view == null)
            return;
        view.startAnimation(a);
    }
}
