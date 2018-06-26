package com.justynaapps.justynazygmunt.simpleboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String currentSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] places = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        currentSign = "X";
        ArrayList<TextView> windows = new ArrayList<>();


        final TextView firstPlace = findViewById(R.id.place_number_1);
        firstPlace.setText(places[0]);
        windows.add(firstPlace);

        final TextView secPlace = findViewById(R.id.place_number_2);
        secPlace.setText(places[1]);
        windows.add(secPlace);

        final TextView thiPlace = findViewById(R.id.place_number_3);
        thiPlace.setText(places[2]);
        windows.add(thiPlace);

        final TextView fourPlace = findViewById(R.id.place_number_4);
        fourPlace.setText(places[3]);
        windows.add(fourPlace);

        final TextView fivePlace = findViewById(R.id.place_number_5);
        fivePlace.setText(places[4]);
        windows.add(fivePlace);

        final TextView sixPlace = findViewById(R.id.place_number_6);
        sixPlace.setText(places[5]);
        windows.add(sixPlace);

        final TextView sevPlace = findViewById(R.id.place_number_7);
        sevPlace.setText(places[6]);
        windows.add(sevPlace);

        final TextView eighPlace = findViewById(R.id.place_number_8);
        eighPlace.setText(places[7]);
        windows.add(eighPlace);

        final TextView ninePlace = findViewById(R.id.place_number_9);
        ninePlace.setText(places[8]);
        windows.add(ninePlace);

//        ArrayList<TextView> places = new ArrayList<>();
//        for (int i = 1; i < 10; i++ ){
//            final TextView notes = findViewById(getResources().getIdentifier("place", "id", getPackageName()));
//            places.add(notes);
//        }
//
//
        for (final TextView window : windows) {
            window.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    window.setText(currentSign);
                    changeCurrentSign();
                }
            });
        }
    }

    private void changeCurrentSign() {
        if (currentSign.equals("X")) {
            currentSign = "O";
        } else {
            currentSign = "X";
        }
    }

}
