package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView current, previous;
    private String currentString, previousString;
    private int brackets = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_Calculator);

        setContentView(R.layout.activity_main);

//        Declaration
        Button allClear, leftBracket, rightBracket, del, exp, log, dot, divide, nine, eight, seven, multiply, four, five, six, subtract, three, two, one, add, zero, equal;


        //Initializaiton : findViewById
        {
            current = (TextView) findViewById(R.id.current);
            previous = (TextView) findViewById(R.id.previous);

            allClear = (Button) findViewById(R.id.all_clear);
            leftBracket = (Button) findViewById(R.id.left_bracket);
            rightBracket = (Button) findViewById(R.id.right_bracket);
            del = (Button) findViewById(R.id.del);
            exp = (Button) findViewById(R.id.exp);
            log = (Button) findViewById(R.id.log);
            dot = (Button) findViewById(R.id.dot);
            divide = (Button) findViewById(R.id.divide);
            multiply = (Button) findViewById(R.id.multiply);
            add = (Button) findViewById(R.id.add);
            subtract = (Button) findViewById(R.id.subtract);
            one = (Button) findViewById(R.id.one);
            two = (Button) findViewById(R.id.two);
            three = (Button) findViewById(R.id.three);
            four = (Button) findViewById(R.id.four);
            five = (Button) findViewById(R.id.five);
            six = (Button) findViewById(R.id.six);
            seven = (Button) findViewById(R.id.seven);
            eight = (Button) findViewById(R.id.eight);
            nine = (Button) findViewById(R.id.nine);
            zero = (Button) findViewById(R.id.zero);
            equal = (Button) findViewById(R.id.equal);
        }

//        Setting onClickListeners
        {
            allClear.setOnClickListener(this);
            leftBracket.setOnClickListener(this);
            rightBracket.setOnClickListener(this);
            del.setOnClickListener(this);
            exp.setOnClickListener(this);
            log.setOnClickListener(this);
            dot.setOnClickListener(this);
            divide.setOnClickListener(this);
            nine.setOnClickListener(this);
            eight.setOnClickListener(this);
            seven.setOnClickListener(this);
            multiply.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            subtract.setOnClickListener(this);
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            add.setOnClickListener(this);
            zero.setOnClickListener(this);
            equal.setOnClickListener(this);

        }

    }


    @Override
    public void onClick(View view) {

        currentString = current.getText().toString();
        previousString = previous.getText().toString();
        int id = view.getId();

        if(id == R.id.all_clear){
            brackets = 0;
            if(currentString!=null){
                currentString = "";
                previousString = "";
                previous.setText(previousString);
                current.setText(currentString);
            }
        }

        else if(id == R.id.del) {
            if (currentString.length() > 0) {
                currentString = currentString.substring(0, currentString.length() - 1);
                current.setText(currentString);
            }
        }

        else if(id == R.id.one) {
            currentString += "1";
            current.setText(currentString);
        }

        else if(id == R.id.two) {
            currentString += "2";
            current.setText(currentString);
        }

        else if(id == R.id.three) {
            currentString += "3";
            current.setText(currentString);
        }

        else if(id == R.id.four) {
            currentString += "4";
            current.setText(currentString);
        }

        else if(id == R.id.five) {
            currentString += "5";
            current.setText(currentString);
        }

        else if(id == R.id.six) {
            currentString += "6";
            current.setText(currentString);
        }

        else if(id == R.id.seven) {
            currentString += "7";
            current.setText(currentString);
        }

        else if(id == R.id.eight) {
            currentString += "8";
            current.setText(currentString);
        }

        else if(id == R.id.nine) {
            currentString += "9";
            current.setText(currentString);
        }

        else if(id == R.id.zero) {
            currentString += "0";
            current.setText(currentString);
        }

        else if(id == R.id.left_bracket) {
            currentString += "(";
            current.setText(currentString);
        }

        else if(id == R.id.right_bracket) {
            currentString += ")";
            brackets--;
            current.setText(currentString);
        }

        else if(id == R.id.exp) {
            currentString += "e(";
            brackets++;
            current.setText(currentString);
        }

        else if(id == R.id.log) {
            currentString += "log(";
            brackets++;
            current.setText(currentString);
        }

        else if(id == R.id.dot) {
            currentString += ".";
            current.setText(currentString);
        }

        else if(id == R.id.equal) {
            previousString = solveEquation(currentString);
            previous.setText(previousString);
            current.setText(currentString);
        }

        else if(id == R.id.add) {
            String temp;
            if(brackets>0){
                temp = ")+";

                brackets--;
            }
            else{
                temp = "+";
            }
            if(!previousString.isEmpty()){
                currentString = previousString+temp;
                previousString = "";
            }
            else{
                currentString += temp;
            }
            current.setText(currentString);
            previous.setText(previousString);
        }

        else if(id == R.id.subtract) {
            String temp;
            if(brackets>0){
                temp = ")-";

                brackets--;
            }
            else{
                temp = "-";
            }
            if(!previousString.isEmpty()){
                currentString = previousString+temp;
                previousString = "";
            }
            else{
                currentString += temp;
            }
            current.setText(currentString);
            previous.setText(previousString);
        }

        else if(id == R.id.multiply) {
            String temp;
            if(brackets>0){
                temp = ")*";

                brackets--;
            }
            else{
                temp = "*";
            }
            if(!previousString.isEmpty()){
                currentString = previousString+temp;
                previousString = "";
            }
            else{
                currentString += temp;
            }
            current.setText(currentString);
            previous.setText(previousString);
        }

        else if(id == R.id.divide) {
            String temp;
            if(brackets>0){
                temp = ")/";

                brackets--;
            }
            else{
                temp = "/";
            }
            if(!previousString.isEmpty()){
                currentString = previousString+temp;
                previousString = "";
            }
            else{
                currentString += temp;
            }
            current.setText(currentString);
            previous.setText(previousString);
        }



    }

    private String solveEquation(String s) {
        String returnString="";
        try{
            Expression expression = new ExpressionBuilder(s).build();
            returnString = String.valueOf(expression.evaluate());
        }
        catch(Exception e){
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            currentString = "";
            previousString = "";

        }
        return returnString;
    }
}