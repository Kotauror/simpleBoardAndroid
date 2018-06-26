package com.justynaapps.justynazygmunt.simpleboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String currentSign;
    String[] places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        currentSign = "X";

        // tworzenie view
        for (int i = 1; i < 10; i++ ){
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if (placeOnMobileGrid.getText() != "X" && placeOnMobileGrid.getText() != "O" && !gameIsWon()) {
                        int position = Integer.parseInt(placeOnMobileGrid.getText().toString()) - 1;
                        places[position] = currentSign;
                        changeCurrentSign();
                        renderGridWithNumbers();
                    }
                }
            });
        }

        renderGridWithNumbers();
    }

    private TextView getTextViewForId(int i) {
        int idOfWindowInMobileGrid = getResources().getIdentifier("place_number_" + i, "id", getPackageName());
        return findViewById(idOfWindowInMobileGrid);

    }

    private void renderGridWithNumbers() {
        for (int i = 1; i < 10; i++) {
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setText(places[i-1]);
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
        return places[index];
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
