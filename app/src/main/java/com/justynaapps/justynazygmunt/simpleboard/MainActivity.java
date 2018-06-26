package com.justynaapps.justynazygmunt.simpleboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String currentSign;
    String[] places;
    ArrayList<TextView> windows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        currentSign = "X";
        windows = new ArrayList<TextView>();

        for (int i = 1; i < 10; i++ ){
            int idOfWindow = getResources().getIdentifier("place_number_" + i, "id", getPackageName());
            final TextView placeOnMobileGrid = findViewById(idOfWindow);
            placeOnMobileGrid.setText(places[i-1]);
            windows.add(placeOnMobileGrid);
        }

        for (final TextView window : windows) {
            window.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (window.getText() != "X" && window.getText() != "O" && !gameIsWon()) {
                        window.setText(currentSign);
                        changeCurrentSign();
                    }
                }
            });
        }
    }

    private final int [][] winningPositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };


    boolean gameIsWon() {
        for (int[] winPath : winningPositions) {
            System.out.print("im here");
            String currentSign = this.valueAtIndex(winPath[0]);
            int currentSignsInWinPath = countCurrentSignsInWinPath(winPath, currentSign);
            if (currentSignsInWinPath == winPath.length) return true;
        }
        return false;
    }

    String valueAtIndex(int index) {
        return (windows.get(index).getText()).toString();
    }

    private int countCurrentSignsInWinPath(int[] winPath, String currentSign) {
        int numberOfCurrentSignsInWinPath = 0;
        for (int aPlaceInWinPath : winPath) {
            if (this.valueAtIndex(aPlaceInWinPath).equals(currentSign)) numberOfCurrentSignsInWinPath++;
        }
        return numberOfCurrentSignsInWinPath;
    }

    private void changeCurrentSign() {
        if (currentSign.equals("X")) {
            currentSign = "O";
        } else {
            currentSign = "X";
        }
    }

}
