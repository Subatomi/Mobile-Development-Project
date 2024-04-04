package com.example.laderamidtermexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ColorMatching extends AppCompatActivity {
    Button[] arrayButton = new Button[9];
    int[] arrayColor = new int[9];
    boolean[] buttonStatus = new boolean[9];
    int[] color = {Color.RED, Color.BLUE, Color.YELLOW};
    boolean winStat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch1);

        arrayButton[0] = findViewById(R.id.btn1);
        arrayButton[1] = findViewById(R.id.btn2);
        arrayButton[2] = findViewById(R.id.btn3);
        arrayButton[3] = findViewById(R.id.btn4);
        arrayButton[4] = findViewById(R.id.btn5);
        arrayButton[5] = findViewById(R.id.btn6);
        arrayButton[6] = findViewById(R.id.btn7);
        arrayButton[7] = findViewById(R.id.btn8);
        arrayButton[8] = findViewById(R.id.btn9);

        for(int i = 0; i<9; i++){
            Random rand = new Random();
            int colorNum = rand.nextInt(3);
            int cln = color[colorNum];
            arrayButton[i].setBackgroundColor(color[colorNum]);
            arrayColor[i] = cln;
            buttonStatus[i] = true;
        }

        for(int i = 0; i<9; i++){
            int finalI = i;
                arrayButton[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int colorid = color[0];
                        int colorRed = Color.RED;
                        int colorBlue = Color.BLUE;
                        int colorYellow = Color.YELLOW;
                        if (arrayColor[finalI] == colorRed) {
                            System.out.println("Turing Blue");
                            colorid = colorBlue;
                        } else if (arrayColor[finalI] == colorBlue) {
                            System.out.println("Turing Yelow");
                            colorid = colorYellow;
                        } else if (arrayColor[finalI] == colorYellow) {
                            System.out.println("Turing Red");
                            colorid = colorRed;
                        }

                        if(buttonStatus[finalI] == true) {
                            arrayButton[finalI].setBackgroundColor(colorid);
                            arrayColor[finalI] = colorid;
                        }
                        int firstcolorid = arrayColor[0];
                        for(int i = 0; i<9; i++){
                            System.out.println(arrayColor[i]);
                            if(firstcolorid != arrayColor[i]){

                                winStat = false;
                            }
                        }
                        System.out.println("-------------------------");
                        if(winStat == true){
                            Toast.makeText(ColorMatching.this, "YOU WIN", Toast.LENGTH_SHORT).show();
                            for(int i = 0; i<9; i++){
                                buttonStatus[i] = false;
                            }
                        }
                    }
                });

        }

        Button btnClick = findViewById(R.id.btnRet);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<9; i++){
                    Random rand = new Random();
                    int colorNum = rand.nextInt(3);
                    arrayButton[i].setBackgroundColor(color[colorNum]);
                    int cln = color[colorNum];
                    arrayColor[i] = cln;
                    buttonStatus[i] = true;
                }
            }
        });
    }
}