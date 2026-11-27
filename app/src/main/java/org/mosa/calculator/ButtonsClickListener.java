package org.mosa.calculator;

import android.content.Context;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonsClickListener {
    public void setOnClickListenerForNumbers(EditText inputDisplay, Button button0, Button button1,
                                             Button button2, Button button3, Button button4, Button button5,
                                             Button button6, Button button7, Button button8, Button button9) {
        button0.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "0");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button1.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "1");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button2.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "2");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button3.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "3");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button4.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "4");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button5.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "5");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button6.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "6");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button7.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "7");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button8.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "8");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });

        button9.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "9");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });
    }

    public void setOnClickListenerForOperators(Context context, EditText inputDisplay, Button buttonAdd,
                                               Button buttonSub, Button buttonMultiply, Button buttonDivide,
                                               Button buttonPercent) {
        buttonAdd.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithPlus(t.substring(0, cursorPosition))) {

                if (cursorPosition >= 0) {

                    String text1 = inputDisplay.getText().toString();
                    String writeAdd = text1.substring(0, cursorPosition - 1) + "+" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithSub(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeAdd = text1.substring(0, cursorPosition - 1) + "+" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithMultiply(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeAdd = text1.substring(0, cursorPosition - 1) + "+" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithDiv(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeAdd = text1.substring(0, cursorPosition - 1) + "+" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "+");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });

        buttonSub.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                text.insert(cursorPosition, "-");
                inputDisplay.setSelection(cursorPosition + 1);
            } else if (cursorPosition > 0 && endsWithPlus(t.substring(0, cursorPosition))) {

                if (cursorPosition >= 0) {

                    String text1 = inputDisplay.getText().toString();
                    String writeAdd = text1.substring(0, cursorPosition - 1) + "-" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithSub(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeAdd = text1.substring(0, cursorPosition - 1) + "-" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithMultiply(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeAdd = text1.substring(0, cursorPosition - 1) + "-" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithDiv(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeAdd = text1.substring(0, cursorPosition - 1) + "-" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeAdd);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "-");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });

        buttonMultiply.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithPlus(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeMultiply = text1.substring(0, cursorPosition - 1) + "×" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeMultiply);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithSub(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeMultiply = text1.substring(0, cursorPosition - 1) + "×" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeMultiply);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithMultiply(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeMultiply = text1.substring(0, cursorPosition - 1) + "×" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeMultiply);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithDiv(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    String text1 = inputDisplay.getText().toString();
                    String writeMultiply = text1.substring(0, cursorPosition - 1) + "×" + text1.substring(cursorPosition);
                    inputDisplay.setText(writeMultiply);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });

        buttonDivide.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithPlus(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeDivide = text1.substring(0, cursorPosition - 1) + "÷" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeDivide);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithSub(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeDivide = text1.substring(0, cursorPosition - 1) + "÷" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeDivide);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithMultiply(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeDivide = text1.substring(0, cursorPosition - 1) + "÷" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeDivide);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else if (cursorPosition > 0 && endsWithDiv(t.substring(0, cursorPosition))) {
                String text1 = inputDisplay.getText().toString();
                String writeDivide = text1.substring(0, cursorPosition - 1) + "÷" + text1.substring(cursorPosition);
                if (cursorPosition >= 0) {
                    inputDisplay.setText(writeDivide);
                    inputDisplay.setSelection(cursorPosition);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "÷");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });

        buttonPercent.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {} else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "%");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });
    }

    public void setOnClickListenerForGrouping(EditText inputDisplay, Button buttonParentheses, Button buttonDot) {
        buttonParentheses.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "(");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });
        buttonParentheses.setOnLongClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, ")");
                inputDisplay.setSelection(cursorPosition + 1);
            }
            return true;
        });
        buttonDot.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String input = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "0.");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            } else {
                int lastPlus = input.lastIndexOf('+');
                int lastMinus = input.lastIndexOf('-');
                int lastMultiply = input.lastIndexOf('*');
                int lastDivide = input.lastIndexOf('/');

                int lastOperatorIndex = Math.max(Math.max(lastPlus, lastMinus), Math.max(lastMultiply, lastDivide));

                String currentSegment = input.substring(lastOperatorIndex + 1);

                if (!currentSegment.contains(".")) {
                    if (cursorPosition >= 0) {
                        text.insert(cursorPosition, ".");
                        inputDisplay.setSelection(cursorPosition + 1);
                    }
                }
            }
        });
    }

    public void setOnClickListenerForScientific(Context context, EditText inputDisplay, Button btnSquareRoot,
                                                Button buttonTan, Button button1Divide, Button btnPower,
                                                Button buttonE, Button buttonCos, Button buttonLog,
                                                Button btnPower2, Button buttonPi, Button btnFactorial,
                                                Button buttonSin, Button btnNatLog, Button buttonEPower,
                                                Button btnPower3, Button btnAbsoluteVal, Button btn2Powerx,
                                                Button btnfract, Button btnCubeRoot) {
        btnSquareRoot.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×√");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "√");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });
        buttonTan.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×tan(");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "tan(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            }
        });
        button1Divide.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×1/");
                    inputDisplay.setSelection(cursorPosition + 3);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "1/");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            }
        });
        btnPower.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithPower(t.substring(0, cursorPosition))) {} else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "^(");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            }
        });
        buttonE.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "e");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });
        buttonCos.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×cos(");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "cos(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            }
        });
        buttonLog.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×log(");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "log(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            }
        });
        btnPower2.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "^2");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            }
        });
        buttonPi.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "π");
                inputDisplay.setSelection(cursorPosition + 1);
            }
        });
        btnFactorial.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else if (cursorPosition > 0 && endsWithDoubleFact(t.substring(0, cursorPosition))) {} else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "!");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });
        buttonSin.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×sin(");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "sin(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            }
        });
        btnNatLog.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×ln(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "ln(");
                    inputDisplay.setSelection(cursorPosition + 3);
                }
            }
        });
        buttonEPower.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {} else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "e^(");
                    inputDisplay.setSelection(cursorPosition + 3);
                }
            }
        });
        btnPower3.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "^3");
                    inputDisplay.setSelection(cursorPosition + 2);
                }
            }
        });
        btnAbsoluteVal.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×abs(");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "abs(");
                    inputDisplay.setSelection(cursorPosition + 4);
                }
            }
        });
        btn2Powerx.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {} else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "2^(");
                    inputDisplay.setSelection(cursorPosition + 3);
                }
            }
        });
        btnfract.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "/");
                    inputDisplay.setSelection(cursorPosition + 1);
                }
            }
        });
        btnCubeRoot.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (cursorPosition >= 0) {
                text.insert(cursorPosition, "∛(");
                inputDisplay.setSelection(cursorPosition + 2);
            }
        });
    }

    private boolean endsWithPlus(String text) {
        return text.endsWith("+");
    }
    private boolean endsWithSub(String text) {
        return text.endsWith("-");
    }
    private boolean endsWithMultiply(String text) {
        return text.endsWith("×");
    }
    private boolean endsWithDiv(String text) {
        return text.endsWith("÷");
    }
    private boolean endsWithPercent(String text) {
        return text.endsWith("%");
    }
    private boolean endsWithPower(String text) {
        return text.endsWith("^(");
    }
    private boolean endsWithDoubleFact(String text) {
        return text.endsWith("!!");
    }
}