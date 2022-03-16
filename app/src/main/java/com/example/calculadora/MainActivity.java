package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b0,  b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button bPoint, bEqual, bClear, bSum, bMul, bRes, bDiv;

    private double num1 = 0.0;
    private double num2 = 0.0;
    private double operacion = 0;

    final int SUMA = 1, RESTA = 2, MULTIPLICACION = 3, DIVISION = 4, SIN_OPERACION = 0;

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // RESULTADO
        txtResult = findViewById(R.id.txtResult);
        txtResult.setText("0");

        // NUMEROS DE LOS BOTONES
        b0 = findViewById(R.id.btn0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("0");
            }
        });

        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("1");
            }
        });

        b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("2");
            }
        });

        b3 =   findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("3");
            }
        });

        b4 = findViewById(R.id.btn4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("4");
            }
        });

        b5 = findViewById(R.id.btn5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("5");
            }
        });

        b6 = findViewById(R.id.btn6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("6");
            }
        });

        b7 = findViewById(R.id.btn7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("7");
            }
        });

        b8 = findViewById(R.id.btn8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("8");
            }
        });

        b9 = findViewById(R.id.btn9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed("9");
            }
        });

        bClear =  findViewById(R.id.btnClear);
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTxt();
            }
        });

        bPoint = findViewById(R.id.btnPoint);
        bPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(".");
            }
        });

        //OPERACIONES
        bSum = findViewById(R.id.btnSum);
        bSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationPressed(SUMA);
            }
        });

        bRes = findViewById(R.id.btnRes);
        bRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationPressed(RESTA);
            }
        });

        bMul = findViewById(R.id.btnMul);
        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationPressed(MULTIPLICACION);
            }
        });

        bDiv = findViewById(R.id.btnDiv);
        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationPressed(DIVISION);
            }
        });

        bEqual = findViewById(R.id.btnEqual);
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    resultPressed();
            }
        });
    }

    private void numberPressed(String numTecla){
        if(txtResult.getText() == "0" && numTecla != ".") {
            txtResult.setText(numTecla);
            //Toast.makeText(this, "0 && !=. " +numTecla, Toast.LENGTH_SHORT).show();
        } else {
            txtResult.setText(txtResult.getText() + numTecla);
            //Toast.makeText(this, "else: " + txtResult.getText()  , Toast.LENGTH_SHORT).show();
        }
        // Mientras no se presione ninguna operacion el valor actual del txtResult se le asigna a la variable num1
        if(operacion == SIN_OPERACION){
            num1 = Double.parseDouble(txtResult.getText().toString());
            //Toast.makeText(this, "Sin operacion - num1 = " +num1, Toast.LENGTH_SHORT).show();
        } else {
            num2 = Double.parseDouble(txtResult.getText().toString());
            //Toast.makeText(this, "Con operacion - num2 = " + num2, Toast.LENGTH_SHORT).show();
        }
    }

    private void operationPressed(Integer operacion){
            this.operacion = operacion;
            num1 = Double.parseDouble(txtResult.getText().toString());
            //Toast.makeText(this, "num1: " + num1, Toast.LENGTH_SHORT).show();
            txtResult.setText("0");
    }

    private void  resultPressed(){
        double result = 0.0;

        if(operacion == SUMA){
            result = num1 + num2;
        }
        if(operacion == RESTA){
            result = num1 - num2;
        }
        if(operacion == MULTIPLICACION){
            result = num1 * num2;
        }
        if(operacion == DIVISION){
            result = num1 / num2;
        }

        //txtResult.setText(String.valueOf(result));
        if(String.valueOf(result).endsWith(".0")){
            txtResult.setText(String.valueOf(result).replace(".0",""));
        }else{
            double roundDbl = Math.round(result*100.0)/100.0;
            txtResult.setText( "%.2f".format(String.valueOf(roundDbl)));
        }
    }
    private void clearTxt(){
        txtResult.setText("0");
        num1 = 0.0;
        num2 = 0.0;
    }
}