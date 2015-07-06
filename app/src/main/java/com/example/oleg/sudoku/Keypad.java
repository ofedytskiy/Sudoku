package com.example.oleg.sudoku;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

/**
 * Created by Oleg on 02.07.2015.
 */
public class Keypad extends Dialog implements View.OnClickListener {
   /**Button responsible for number 1*/
    private Button keypad1;
    /**Button responsible for number 1*/
    private Button keypad2;
    /**Button responsible for number 1*/
    private Button keypad3;
    /**Button responsible for number 1*/
    private Button keypad4;
    /**Button responsible for number 1*/
    private Button keypad5;
    /**Button responsible for number 1*/
    private Button keypad6;
    /**Button responsible for number 1*/
    private Button keypad7;
    /**Button responsible for number 1*/
    private Button keypad8;
    /**Button responsible for number 1*/
    private Button keypad9;
    /** Counts the amount of able moves*/
    private int counter;
    /**GmaeActivity object*/
    private GameActivity gameActivity;
    /**Final int, that is equal for number 9*/
    private static final int COUNTER_FOR_MOVES = 9;


    public Keypad(Context context, GameActivity gameActivity) {
        super(context);
        this.gameActivity = gameActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.dialog_title);
        setContentView(R.layout.keypad);
        setKeypad();
        showAbleKeys();

        if (counter == COUNTER_FOR_MOVES) {
            setTitle(R.string.no_moves);
        }
    }


    @Override
    public void onClick(View v) {

        gameActivity.setCorrectIconForBtn(v);
        if (checkArrayForMoves()) {

            showAlertDialog();
        }

    }
   /**Creating a keypad and adding onClickListener for every button*/
    private void setKeypad() {

        keypad1 = (Button) findViewById(R.id.keypad_1);
        keypad1.setOnClickListener(this);

        keypad2 = (Button) findViewById(R.id.keypad_2);
        keypad2.setOnClickListener(this);

        keypad3 = (Button) findViewById(R.id.keypad_3);
        keypad3.setOnClickListener(this);

        keypad4 = (Button) findViewById(R.id.keypad_4);
        keypad4.setOnClickListener(this);

        keypad5 = (Button) findViewById(R.id.keypad_5);
        keypad5.setOnClickListener(this);

        keypad6 = (Button) findViewById(R.id.keypad_6);
        keypad6.setOnClickListener(this);

        keypad7 = (Button) findViewById(R.id.keypad_7);
        keypad7.setOnClickListener(this);

        keypad8 = (Button) findViewById(R.id.keypad_8);
        keypad8.setOnClickListener(this);

        keypad9 = (Button) findViewById(R.id.keypad_9);
        keypad9.setOnClickListener(this);

        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(this);


    }

    /**If the keypad is invalid it is invisible*/
    private void showAbleKeys() {
       counter = 0;

        setInvisibleOrNot(keypad1, 1);
        setInvisibleOrNot(keypad2, 2);
        setInvisibleOrNot(keypad3, 3);
        setInvisibleOrNot(keypad4, 4);
        setInvisibleOrNot(keypad5, 5);
        setInvisibleOrNot(keypad6, 6);
        setInvisibleOrNot(keypad7, 7);
        setInvisibleOrNot(keypad8, 8);
        setInvisibleOrNot(keypad9, 9);

    }

   /**Checks is the keypad valid to be visible*/
    private void setInvisibleOrNot(View v, int i) {
        int[][] arrayOfSomeDif = gameActivity.getArrayOfSomeDif();

        if (!gameActivity.check(gameActivity.selX, gameActivity.selY, i, arrayOfSomeDif)) {
            v.setVisibility(View.INVISIBLE);
            counter++;
        }
    }
    /**Checks if there are more empry cells*/
    public boolean checkArrayForMoves() {

      int[][] arrayOfSomeDif = gameActivity.getArrayOfSomeDif();

        for (int i = 0; i< 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (arrayOfSomeDif[i][j] == 0) {

                    return false;
                }
            }
        }
        return true;
    }
    /** Shows AlertDialog if level is completed*/
    public void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(gameActivity);
        builder.setTitle(R.string.alert_title)
                .setMessage(R.string.alert_text)
                .setCancelable(false)
                .setNegativeButton(R.string.alert_key_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                gameActivity.finish();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
