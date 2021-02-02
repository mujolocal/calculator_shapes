package com.example.core_material.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> answer = new MutableLiveData<Integer>() ;

    public LiveData<Integer> getAnswer(){
        return answer;
    }




    public void operate(ArrayList<Integer> operands, ArrayList<String> operators) {

        Integer answerHolder = operands.get(0);

        for (int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case "-":
                    answerHolder = answerHolder - operands.get(i + 1);
                    break;
                case "+":
                    answerHolder = answerHolder + operands.get(i + 1);
                    break;
                case "X":
                    answerHolder = answerHolder * operands.get(i + 1);
                    break;
                case "/":
                    answerHolder = answerHolder / operands.get(i + 1);
                    break;
                case "%":
                    answerHolder = answerHolder % operands.get(i + 1);
                    break;
                default:
                    System.out.println("error or something");
            }

        }
        answer.setValue(answerHolder);
        return;
    }
}

