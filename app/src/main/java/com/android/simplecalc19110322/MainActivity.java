package com.android.simplecalc19110322;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the calculator class and all the views
        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }

    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onLog(View view) {
        compute(Calculator.Operator.LOG);
    }

    public void onFactorial(View view) {
        compute(Calculator.Operator.FAC);
    }

    public void onPow(View view) {
        compute(Calculator.Operator.POW);
    }

    public void onClear(View view) {
        compute(Calculator.Operator.CLR);
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;

        String result;
        switch (operator) {
            case ADD:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                result = String.valueOf(mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                result = String.valueOf(mCalculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                result = String.valueOf(mCalculator.div(operandOne, operandTwo));
                break;
            case MUL:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                result = String.valueOf(mCalculator.mul(operandOne, operandTwo));
                break;
            case LOG:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                try {
                    result = String.valueOf(mCalculator.log(operandOne, operandTwo));
                } catch (ArithmeticException nfe) {
                    Log.e(TAG, "ArithmeticException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                break;
            case POW:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                    operandTwo = getOperand(mOperandTwoEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }

                try {
                    result = String.valueOf(mCalculator.pow(operandOne, operandTwo));
                } catch (ArithmeticException nfe) {
                    Log.e(TAG, "ArithmeticException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                break;
            case FAC:
                try {
                    operandOne = getOperand(mOperandOneEditText);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, "NumberFormatException", nfe);
                    mResultTextView.setText(getString(R.string.computationError));
                    return;
                }
                result = String.valueOf(mCalculator.fac(operandOne));
                break;
            case CLR:
                result = String.valueOf(mCalculator.clr());
                mOperandOneEditText.getText().clear();
                mOperandTwoEditText.getText().clear();
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResultTextView.setText(result);
    }
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }



    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }


}

class Calculator {

    // Available operations
    public enum Operator {ADD, SUB, DIV, MUL,LOG,POW,FAC,CLR}

    /**
     * Addition operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtract operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divide operation
     */
    public double div(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    /**
     * Multiply operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double log(double firstOperand, double secondOperand) throws ArithmeticException{
        if((firstOperand > 0)&&(secondOperand > 0)&&(secondOperand!=1)){
            return Math.log(firstOperand) / Math.log(secondOperand);
        }
        else throw new ArithmeticException();
    }

    public double fac(double firstOperand){
        double result = 1;
        for(double i=2;i<= firstOperand;i++){
            result*=i;
        }
        return result;
    }

    public double pow(double firstOperand, double secondOperand) throws ArithmeticException{
        if((firstOperand!=0)&&(secondOperand)!=0) return Math.pow(firstOperand, secondOperand);
        else throw new ArithmeticException();
    }

    public double clr(){

        return 0;
    }

}