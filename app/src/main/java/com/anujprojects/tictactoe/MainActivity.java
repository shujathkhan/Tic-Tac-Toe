package com.anujprojects.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    boolean turn = true;
    int count = 0;
    Button[] Array = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = (Button) findViewById(R.id.A1);
        b1 = (Button) findViewById(R.id.B1);
        c1 = (Button) findViewById(R.id.C1);
        a2 = (Button) findViewById(R.id.A2);
        b2 = (Button) findViewById(R.id.B2);
        c2 = (Button) findViewById(R.id.C2);
        a3 = (Button) findViewById(R.id.A3);
        b3 = (Button) findViewById(R.id.B3);
        c3 = (Button) findViewById(R.id.C3);
        Array = new Button[] { a1, a2, a3, b1, b2, b3, c1, c2, c3 };

        for (Button b : Array)
            b.setOnClickListener(this);

        Button bnew = (Button) findViewById(R.id.button1);
        bnew.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                turn = true;
                count = 0;
                enableOrDisable(true);
            }
        });
    }

    @Override
    public void onClick(View v) {

        buttonClicked(v);
    }

    private void buttonClicked(View v) {
        Button b = (Button) v;
        if (turn) {

            b.setText("X");

        } else {

            b.setText("O");
        }
        count++;
        b.setClickable(false);
        b.setBackgroundColor(Color.LTGRAY);
        turn = !turn;

        checkForWinner();
    }

    private void checkForWinner() {

        boolean winner = false;


        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()
                && !a1.isClickable())
            winner = true;
        else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()
                && !b1.isClickable())
            winner = true;
        else if (c1.getText() == c2.getText() && c2.getText() == c3.getText()
                && !c1.isClickable())
            winner = true;


        else if (a1.getText() == b1.getText() && b1.getText() == c1.getText()
                && !a1.isClickable())
            winner = true;
        else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()
                && !b2.isClickable())
            winner = true;
        else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()
                && !c3.isClickable())
            winner = true;

        else if (a1.getText() == b2.getText() && b2.getText() == c3.getText()
                && !a1.isClickable())
            winner = true;
        else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()
                && !b2.isClickable())
            winner = true;


        if (winner) {
            if (!turn)
                message("X win");
            else
                message("O win");
            enableOrDisable(false);
        } else if (count == 9)
            message("It's Draw!");

    }

    private void message(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }

    private void enableOrDisable(boolean enable) {
        for (Button b : Array) {
            b.setText("");
            b.setClickable(enable);
            if (enable) {
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
            } else {
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }
}
