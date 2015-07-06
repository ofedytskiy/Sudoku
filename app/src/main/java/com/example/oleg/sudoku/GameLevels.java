package com.example.oleg.sudoku;


import android.util.SparseArray;

/**
 * Created by Oleg on 02.07.2015.
 */
public class GameLevels {


    private int[][] easyArray = {
            {7, 0, 9, 0, 2, 6, 0, 5, 8},{6, 0, 4, 0, 0, 5, 2, 7, 1},{0, 1, 2, 0, 4, 7, 3, 0, 9},{0, 4, 0, 5, 9, 0, 8, 2, 7},
            {9, 0, 0, 2, 6, 8, 0, 4, 3},{1, 0, 8, 0, 0, 3, 6, 9, 5},{0, 7, 5, 0, 1, 2, 9, 0, 6},{0, 0, 0, 6, 5, 4, 7, 0, 2},
            {0, 6, 0, 7, 8, 0, 5, 3, 0}
    };
    private int[][] mediumArray = {
            {8, 3, 0, 4, 0, 0, 0, 2, 7}, {2, 9, 0, 0, 5, 7, 0, 0, 0}, {0, 1, 0, 0, 9, 3, 0, 5, 0}, {0, 6, 0, 0, 3, 0, 7, 8, 2},
            {0, 2, 3, 0, 7, 0, 5, 0, 9}, {0, 4, 0, 5, 2, 0, 0, 6, 3}, {6, 5, 2, 7, 0, 0, 3, 0, 0}, {0, 8, 0, 3, 0, 0, 2, 7, 6},
            {0, 0, 4, 0, 6, 0, 8, 1, 0}
    };

    private int[][] hardArray =  {
            {0, 0, 6, 0, 9, 0, 0, 1, 0}, {0, 1, 0, 0, 3, 5, 8, 0, 0},{5, 0, 0, 0, 0, 0, 2, 0, 0},{0, 0, 0, 9, 0, 7, 4, 0, 0},
            {3, 0, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 9, 0, 5, 0, 0, 0, 1}, {0, 0, 0, 0, 7, 0, 1, 0, 0},{0, 0, 0, 0, 0, 9, 6, 0, 8},
            {0, 8, 0, 0, 6, 0, 0, 3, 0}
    };

    /**Chooses the difficulty level*/
    public int[][] difficulty(int index) {

        switch (index) {

            case 0: return easyArray;
            case 1: return mediumArray;
            case 2: return hardArray;
            default : return easyArray;
        }
    }




}
