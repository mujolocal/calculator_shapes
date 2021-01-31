package com.example.core_material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] equationBtnRef = new int[] { R.id.division_btn, R.id.modulo_btn,
            R.id.multiplication_btn, R.id.addition_btn, R.id.subtraction_btn};
    private final int[] btnRef = new int[] {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,R.id.dot_btn,};

    private TextView answerView;
    private TextView equationView;
    private AppCompatTextView cBtn;
    private AppCompatTextView equalsBtn;
    private ArrayList<Integer> opperands;
    private ArrayList<String> opperations;
    private  AppCompatTextView[] btnarray;
    private AppCompatTextView[] equationBtnarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opperands = new ArrayList<>();
        opperations = new ArrayList<>();
        btnarray = new AppCompatTextView[btnRef.length];
        equationBtnarray = new AppCompatTextView[equationBtnRef.length];

        equationView = findViewById(R.id.equation_txt);
        answerView = findViewById(R.id.answer_txt);
        cBtn = findViewById(R.id.c_btn);
        equalsBtn = findViewById(R.id.equals_btn);

        for ( int a =0; a<btnRef.length ;a++){
            final int i = a;
            btnarray[i] = findViewById(btnRef[i]);
            btnarray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String current = equationView.getText().toString();
                        equationView.append(btnarray[i].getText().toString());
                }
            });
        }
        for ( int a =0; a<equationBtnRef.length ;a++){
            final int i = a;
            equationBtnarray[i] = findViewById(equationBtnRef[i]);
            equationBtnarray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String temp = equationView.getText().toString();
                    String equationBtnTxtTemp = equationBtnarray[i].getText().toString();
                     opperands.add(Integer.parseInt(temp));
                     opperations.add(equationBtnTxtTemp);
                     equationView.setText("");
                     answerView.append(temp+equationBtnTxtTemp);



                }
            });
        }

        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clear();

            }
        });
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opperations.size() == opperands.size() ){
                    String temp = equationView.getText().toString();
                    opperands.add(Integer.parseInt(temp));
                    int answerHolder = opperands.get(0);

                     for (int i =0;i < opperations.size();i++){
                         switch (opperations.get(i)){
                             case "-":
                                 answerHolder = answerHolder - opperands.get(i+1);
                                 break;
                             case "+":
                                 answerHolder = answerHolder + opperands.get(i+1);
                                 break;
                             case "X":
                                 answerHolder = answerHolder * opperands.get(i+1);
                                 break;
                             case "/":
                                 answerHolder = answerHolder / opperands.get(i+1);
                                 break;
                             case "%":
                                 answerHolder = answerHolder % opperands.get(i+1);
                                 break;
                             default:
                                 System.out.println("error or something");
                         }
                         clear();
                         answerView.setText(String.valueOf(answerHolder));
                     }
                }else{
                    clear();
                    answerView.setText("You did something wrong");
                }
            }
        });
    }
    private void clear(){
        equationView.setText("");
        answerView.setText("");
        opperands.clear();
        opperations.clear();
    }

}