package com.example.oleg.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by Oleg on 02.07.2015.
 */
public class GameActivity extends Activity implements View.OnClickListener {

    /**x coordinate of the selected icon*/
    public int selX;
    /**y coordinate of the selected icon*/
    public int selY;
    /**Width of one cell*/
    private int widthOfCell;
    /**Array of ImageViews, created at this activity*/
    private ImageView [][] imageViewArray;
    /**Array with choosed difficulty level*/
    private int[][] arrayOfSomeDif;
    /**Final int that is equal to number 0*/
    public static final int DIFFICULTY_EASY = 0;
    /**Final int that is equal to number 1*/
    public static final int DIFFICULTY_MEDIUM = 1;
    /**Final int that is equal to number 2*/
    public static final int DIFFICULTY_HARD = 2;
    /**Keypad object*/
    private Keypad keypad;
    /**GameLevels object*/
    private GameLevels gameLevels;
    /**SharedPreferences name of file*/
    public static final String GAME_PROCESS = "gameProcess";
    private SharedPreferences gameProcess;
    /**Layout created when user starts playing*/
    private GridLayout gameActivityLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);
        imageViewArray = imageViewArray(9, 9);
        setGridLayout(9);
        int diff = getIntent().getIntExtra("difficulty", DIFFICULTY_EASY);

        createGrid(imageViewArray, 9, 9, diff);

        addMargine(imageViewArray[2][2], 0, 0, 3, 0);
        addMargine(imageViewArray[5][5], 0, 0, 3, 0);
        addMargine(imageViewArray[2][5], 0, 0, 0, 3);
        addMargine(imageViewArray[5][4], 0, 0, 0, 3);

        gameProcess = getSharedPreferences(GAME_PROCESS, Context.MODE_PRIVATE);

    }



    @Override
    public void onClick(View v) {
        selX = v.getId() / 100;
        selY = v.getId() % 100;
        keypad = new Keypad(this, GameActivity.this);

        keypad.show();

    }
    /**Method divides the screen's width into some number of parts*/
    private void setWidthOfCell(int number) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthOfCell = size.x / number;
    }

/**Making the main game field*/
 private void createGrid(ImageView[][] array, int lines , int columns, int diff) {
     setWidthOfCell(columns);
     gameLevels = new GameLevels();
     setArrayOfSomeDif(diff);



     for (int i = 0; i < lines; i++) {
         for (int j = 0; j < columns; j++) {

             array[i][j] = new ImageView(this);
             array[i][j].setAdjustViewBounds(true);
             array[i][j].setId(i * 100 + j);
             array[i][j].setMaxHeight((int) widthOfCell);
             array[i][j].setScaleType(ImageView.ScaleType.FIT_XY);
             chooseCorrectIcons(array[i][j], arrayOfSomeDif[i][j]);
     gameActivityLayout.addView(array[i][j]);

 }
 }


 }
    /**Adds a margine for image*/
    private void addMargine(ImageView v, int left, int top, int right, int bottom) {

        GridLayout.LayoutParams gp = new GridLayout.LayoutParams();
        gp.setMargins(left, top, right, bottom);
        v.setLayoutParams(gp);

    }
    /**Creates a GridLayout with n number of columns*/
    private void setGridLayout(int columns) {

     gameActivityLayout = (GridLayout) findViewById(R.id.gameActivityLayout);
     gameActivityLayout.setColumnCount(columns);
    }
   /**Creates an ImageView array */
    private ImageView[][] imageViewArray(int a, int b) {

        ImageView[][] array = new ImageView[a][b];
        return array;
    }

   private void chooseCorrectIcons(ImageView v, int number) {

       switch (number) {

           case 0: v.setImageResource(R.drawable.empty); v.setOnClickListener(this); v.setClickable(true); break;
           case 1: v.setImageResource(R.drawable.one); break;
           case 2: v.setImageResource(R.drawable.two); break;
           case 3: v.setImageResource(R.drawable.three); break;
           case 4: v.setImageResource(R.drawable.four); break;
           case 5: v.setImageResource(R.drawable.five); break;
           case 6: v.setImageResource(R.drawable.six); break;
           case 7: v.setImageResource(R.drawable.seven); break;
           case 8: v.setImageResource(R.drawable.eight); break;
           case 9: v.setImageResource(R.drawable.nine); break;
           default:break;
       }
   }

    public void setCorrectIconForBtn(View v) {

        switch (v.getId()) {
            case R.id.keypad_1:
                imageViewArray[selX][selY].setImageResource(R.drawable.one_o);
                arrayOfSomeDif[selX][selY] = 1; keypad.cancel(); break;
            case R.id.keypad_2:
                imageViewArray[selX][selY].setImageResource(R.drawable.two_o);
                arrayOfSomeDif[selX][selY] = 2; keypad.cancel(); break;
            case R.id.keypad_3:
                imageViewArray[selX][selY].setImageResource(R.drawable.three_o);
                arrayOfSomeDif[selX][selY] = 3; keypad.cancel(); break;
            case R.id.keypad_4:
                imageViewArray[selX][selY].setImageResource(R.drawable.four_o);
                arrayOfSomeDif[selX][selY ] = 4; keypad.cancel(); break;
            case R.id.keypad_5:
                imageViewArray[selX][selY].setImageResource(R.drawable.five_o);
                arrayOfSomeDif[selX][selY] = 5; keypad.cancel(); break;
            case R.id.keypad_6:
                imageViewArray[selX][selY].setImageResource(R.drawable.six_o);
                arrayOfSomeDif[selX][selY] = 6; keypad.cancel(); break;
            case R.id.keypad_7:
                imageViewArray[selX][selY].setImageResource(R.drawable.seven_o);
                arrayOfSomeDif[selX][selY] = 7; keypad.cancel(); break;
            case R.id.keypad_8:
                imageViewArray[selX][selY].setImageResource(R.drawable.eight_o);
                arrayOfSomeDif[selX][selY] = 8; keypad.cancel(); break;
            case R.id.keypad_9:
                imageViewArray[selX][selY].setImageResource(R.drawable.nine_o);
                arrayOfSomeDif[selX][selY] = 9; keypad.cancel(); break;
            case R.id.cancel_btn:
                imageViewArray[selX][selY].setImageResource(R.drawable.empty);
                keypad.cancel(); arrayOfSomeDif[selX][selY] = 9; break;
            default: break;
        }
    }

    /**Set array of the level's difficulty*/
    private void setArrayOfSomeDif(int i) {

        arrayOfSomeDif = gameLevels.difficulty(i);
    }

    /**Returns arrayOfSomeDif*/
    public int[][] getArrayOfSomeDif() {

       return arrayOfSomeDif;
    }

    /**Checks line for numbers equality*/
    public boolean checkLine(int selX, int num, int [][] array) {

        for (int i = 0; i < 9; i++) {

            if (array[selX][i] == num)
                return false;
        }

        return true;
    }

    /**Checks colomn for numbers equality*/
    public boolean checkColon(int selY, int num, int [][] array) {

        for (int i = 0; i < 9; i++) {

            if (array[i][selY] == num)
                return false;
        }
        return true;
    }

    /**Checks cell for numbers equality*/
    public boolean checkCell(int selX, int selY,int num, int [][] array) {

        int a = selX;
        int b = selY;

        a = (a/3) * 3;
        b = (b/3)*3;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if(array[a + i][b + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**Checks the number for being valid at some position*/
    public boolean check(int selX, int selY,int num, int [][] array) {

        return checkLine(selX, num, array) && checkColon(selY, num, array) && checkCell(selX, selY, num, array);
    }

    private void saveGameGrid() {

        gameProcess = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = gameProcess.edit();
       for (int i = 0; i < 9; i++) {

           for (int j = 0; j < 9; j++) {

               editor.putInt(Integer.toString(i) + Integer.toString(j), arrayOfSomeDif[i][j]);
           }
       }

        editor.apply();

    }

    private void loadGameGrid() {

        gameProcess = getPreferences(MODE_PRIVATE);


            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    arrayOfSomeDif[i][j] = gameProcess.getInt(Integer.toString(i) + Integer.toString(j), 0);
                }
            }


    }




}


