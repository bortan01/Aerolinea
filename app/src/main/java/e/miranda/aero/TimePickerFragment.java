package e.miranda.aero;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener listener;


    public static TimePickerFragment newInstance(TimePickerDialog.OnTimeSetListener listener) {
        TimePickerFragment fragment = new TimePickerFragment();
        return fragment;
    }

        public void setListener(TimePickerDialog.OnTimeSetListener listener) {
            this.listener = listener;
        }

        @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), listener, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }
}