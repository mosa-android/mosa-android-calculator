package org.mosa.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.mariuszgromada.math.mxparser.Expression;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText inputDisplay;
    private RadioButton radioButtonAsSystem;
    private RadioButton radioButtonDark;
    private RadioButton radioButtonLight;
    private SharedPreferences.Editor editor;
    private ArrayList<ListItem> itemsList;
    private CustomAdapter adapter;
    private ListView itemListView;
    private TextView noItemTextView;
    private Button clearHistory;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_LIST = "ListItems";
    private LinearLayout keyboardScientific;
    private BottomSheetDialog themeBottomSheetDialog;
    private BottomSheetDialog historyBottomSheetDialog;
    private ListView historyItemListView;
    private TextView historyNoItemTextView;
    private Button clearHistoryButton;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.input);
        keyboardScientific = findViewById(R.id.keyboardScientific);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!DeviceTypeChecker.isTablet(this)) {
                WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
                WindowInsetsController insetsController = getWindow().getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(WindowInsets.Type.statusBars());
                    insetsController.setSystemBarsBehavior(
                            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                    );
                }
            }
        }

        itemListView = findViewById(R.id.historyList);
        MaterialButton button0 = findViewById(R.id.btn0);
        MaterialButton button1 = findViewById(R.id.btn1);
        MaterialButton button2 = findViewById(R.id.btn2);
        MaterialButton button3 = findViewById(R.id.btn3);
        MaterialButton button4 = findViewById(R.id.btn4);
        MaterialButton button5 = findViewById(R.id.btn5);
        MaterialButton button6 = findViewById(R.id.btn6);
        MaterialButton button7 = findViewById(R.id.btn7);
        MaterialButton button8 = findViewById(R.id.btn8);
        MaterialButton button9 = findViewById(R.id.btn9);
        SharedPreferences sharedPreferences = getSharedPreferences("ThemePreferences", 0);
        int themeRadioButtonBackup = sharedPreferences.getInt("themeRadioButtonBackup", 1);
        editor = sharedPreferences.edit();
        MaterialButton buttonAdd = findViewById(R.id.add);
        findViewById(R.id.parentheses);
        MaterialButton buttonParentheses;
        MaterialButton buttonSub = findViewById(R.id.subtract);
        MaterialButton buttonDivide = findViewById(R.id.division);
        MaterialButton buttonDot = findViewById(R.id.btnPoint);
        MaterialButton buttonMultiply = findViewById(R.id.multiply);
        Button buttonClear = findViewById(R.id.clear);
        buttonParentheses = findViewById(R.id.parentheses);
        MaterialButton buttonClearAll = findViewById(R.id.clear_all);
        MaterialButton buttonEqual = findViewById(R.id.equal);
        MaterialButton buttonPercent = findViewById(R.id.percent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.no_text));
        itemsList = loadListFromPreferences();
        adapter = new CustomAdapter(this, itemsList);
        noItemTextView = findViewById(R.id.textView4);
        clearHistory = findViewById(R.id.clear_history);
        MaterialButton btnSquareRoot = findViewById(R.id.btnSquareRoot);
        MaterialButton buttonTan = findViewById(R.id.btnTan);
        MaterialButton button1Divide = findViewById(R.id.btn1div);
        MaterialButton btnPower = findViewById(R.id.btnPower);
        MaterialButton buttonE = findViewById(R.id.btne);
        MaterialButton buttonCos = findViewById(R.id.btnCos);
        MaterialButton buttonLog = findViewById(R.id.btnLog);
        MaterialButton btnPower2 = findViewById(R.id.btnPower2);
        MaterialButton buttonPi = findViewById(R.id.btnPi);
        MaterialButton btnFactorial = findViewById(R.id.btnFactorial);
        MaterialButton buttonSin = findViewById(R.id.btnSin);
        MaterialButton btnNatLog = findViewById(R.id.btnNatLog);
        MaterialButton buttonEPower = findViewById(R.id.btnepx);
        MaterialButton btnAbsoluteVal = findViewById(R.id.btnAbsoluteVal);
        MaterialButton btnPower3 = findViewById(R.id.btnxPower3);
        MaterialButton btnCubeRoot = findViewById(R.id.btnCubeRoot);
        MaterialButton btn2Powerx = findViewById(R.id.btn2Powerx);
        MaterialButton btnfract = findViewById(R.id.btnfract);
        MaterialButton btnHyp = findViewById(R.id.btnHyp);
        MaterialButton btnPowerM1 = findViewById(R.id.btnPowerM1);
        inputDisplay.setShowSoftInputOnFocus(false);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        @SuppressLint("InflateParams") View bottomView = getLayoutInflater().inflate(R.layout.hyp_keyboard_bottom_dialog, null);
        bottomSheetDialog.setContentView(bottomView);
        themeBottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        @SuppressLint("InflateParams") View themeBottomView = getLayoutInflater().inflate(R.layout.theme_bottom_dialog, null);
        themeBottomSheetDialog.setContentView(themeBottomView);
        historyBottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        @SuppressLint("InflateParams") View historyBottomView = getLayoutInflater().inflate(R.layout.history_bottom_dialog, null);
        historyBottomSheetDialog.setContentView(historyBottomView);
        historyItemListView = historyBottomView.findViewById(R.id.historyList);
        Button doneButton = historyBottomView.findViewById(R.id.done);
        clearHistoryButton = historyBottomView.findViewById(R.id.clear_history);
        historyNoItemTextView = historyBottomView.findViewById(R.id.textView4);
        radioButtonAsSystem = themeBottomView.findViewById(R.id.systemRadioButton);
        radioButtonDark = themeBottomView.findViewById(R.id.darkRadioButton);
        radioButtonLight = themeBottomView.findViewById(R.id.lightRadioButton);
        RadioGroup radioGroupTheme = themeBottomView.findViewById(R.id.radioGroupTheme);
        Button cancel = themeBottomView.findViewById(R.id.cancel);
        Button sinPowerM1 = bottomView.findViewById(R.id.sinPowerM1);
        Button cosPowerM1 = bottomView.findViewById(R.id.cosPowerM1);
        Button tanPowerM1 = bottomView.findViewById(R.id.tanPowerM1);
        Button sinh = bottomView.findViewById(R.id.sinh);
        Button cosh = bottomView.findViewById(R.id.cosh);
        Button tanh = bottomView.findViewById(R.id.tanh);
        Button coth = bottomView.findViewById(R.id.coth);
        Button sech = bottomView.findViewById(R.id.sech);
        Button csch = bottomView.findViewById(R.id.csch);
        Button arcSinh = bottomView.findViewById(R.id.arcSinh);
        Button arcCosh = bottomView.findViewById(R.id.arcCosh);
        Button arcTanh = bottomView.findViewById(R.id.arcTanh);
        Button cancelDialogBottom = bottomView.findViewById(R.id.cancelDialog);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewGroup keyboardLayout = findViewById(R.id.keyboard);
        if (keyboardLayout != null) {
            attachTouchHapticRecursively(keyboardLayout);
        }
        cancelDialogBottom.setOnClickListener(v -> bottomSheetDialog.dismiss());

        radioGroupTheme.setOnCheckedChangeListener((radioGroup, i) -> {
            if (radioButtonAsSystem.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                editor.putInt("themeRadioButtonBackup", 1);
            } else if (radioButtonDark.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putInt("themeRadioButtonBackup", 2);
            } else if (radioButtonLight.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor.putInt("themeRadioButtonBackup", 3);
            }
            editor.commit();
        });
        if (themeRadioButtonBackup == 1) {
            radioButtonAsSystem.setChecked(true);
        } else if (themeRadioButtonBackup == 2) {
            radioButtonDark.setChecked(true);
        } else if (themeRadioButtonBackup == 3) {
            radioButtonLight.setChecked(true);
        }

        cancel.setOnClickListener(v -> themeBottomSheetDialog.dismiss());
        doneButton.setOnClickListener( v -> historyBottomSheetDialog.dismiss());
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    keyboardScientific.setVisibility(View.GONE);
                } else if (position == 1) {
                    keyboardScientific.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    keyboardScientific.setVisibility(View.GONE);
                } else if (position == 1) {
                    keyboardScientific.setVisibility(View.VISIBLE);
                }
            }
        });
        if (DeviceTypeChecker.isTablet(this)) {
            Objects.requireNonNull(tabLayout.getTabAt(1)).select();
        } else {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Objects.requireNonNull(tabLayout.getTabAt(1)).select();
            } else {
                Objects.requireNonNull(tabLayout.getTabAt(0)).select();
            }
        }

        ButtonsClickListener buttonsClickListener = new ButtonsClickListener();
        buttonsClickListener.setOnClickListenerForNumbers(inputDisplay, button0, button1, button2, button3,
                button4, button5, button6, button7, button8, button9);
        buttonsClickListener.setOnClickListenerForOperators(this, inputDisplay, buttonAdd, buttonSub,
                buttonMultiply, buttonDivide, buttonPercent);
        buttonsClickListener.setOnClickListenerForGrouping(inputDisplay, buttonParentheses, buttonDot);
        buttonsClickListener.setOnClickListenerForScientific(this, inputDisplay, btnSquareRoot,
                buttonTan, button1Divide, btnPower, buttonE, buttonCos, buttonLog, btnPower2, buttonPi,
                btnFactorial, buttonSin, btnNatLog, buttonEPower, btnPower3, btnAbsoluteVal, btn2Powerx,
                btnfract, btnCubeRoot);

        inputDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 7) {
                    if (s.length() > 11) {
                        inputDisplay.setTextSize(30);
                    } else {
                        inputDisplay.setTextSize(45);
                    }
                } else if (s.length() <= 7) {
                    inputDisplay.setTextSize(60);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonClear.setOnClickListener(view -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (inputDisplay.getText().length() > 0) {
                if (cursorPosition > 0) {
                    text.delete(cursorPosition - 1, cursorPosition);
                    inputDisplay.setSelection(cursorPosition - 1);
                }
            } else {
                inputDisplay.setText("");
            }
        });

        buttonClearAll.setOnClickListener(view -> inputDisplay.setText(""));

        buttonEqual.setOnClickListener(view -> {
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else {
                String input = inputDisplay.getText().toString();
                String title = input.trim();
                double result = evaluateExpression(input);
                String text2 = String.valueOf(result);
                if (text2.endsWith(".0")) {
                    inputDisplay.setText(String.valueOf((long) result));
                } else {
                    inputDisplay.setText(String.valueOf(result));
                }
                inputDisplay.setSelection(inputDisplay.getText().length());
                String subtitle = inputDisplay.getText().toString().trim();
                if (!title.isEmpty() && !subtitle.isEmpty()) {
                    if (!title.equals(subtitle)) {
                        itemsList.add(new ListItem(title, subtitle));
                        itemListView.smoothScrollToPosition(adapter.getCount() - 1);
                        adapter.notifyDataSetChanged();
                        saveListToPreferences();
                    }
                }
                onHistoryListItemChange();
            }
        });
        clearHistory.setOnClickListener(v -> {
            itemsList.clear();
            adapter.notifyDataSetChanged();
            onHistoryListItemChange();
            saveListToPreferences();
        });

        clearHistoryButton.setOnClickListener(v -> {
            itemsList.clear();
            adapter.notifyDataSetChanged();
            onHistoryListItemChange();
            saveListToPreferences();
        });

        itemListView.setAdapter(adapter);
        historyItemListView.setAdapter(adapter);

        itemListView.setOnItemClickListener((parent, view, position, id) -> {
            ListItem clickedItem = itemsList.get(position);
            inputDisplay.setText(inputDisplay.getText().toString() + clickedItem.getSubtitle());
            inputDisplay.setSelection(inputDisplay.getText().length());
        });
        historyItemListView.setOnItemClickListener((parent, view, position, id) -> {
            ListItem clickedItem = itemsList.get(position);
            inputDisplay.setText(inputDisplay.getText().toString() + clickedItem.getSubtitle());
            inputDisplay.setSelection(inputDisplay.getText().length());
        });

        itemListView.setOnItemLongClickListener((parent, view, position, id) -> {
            ListItem longClickedItem = itemsList.get(position);

            inputDisplay.setText(inputDisplay.getText().toString() + longClickedItem.getTitle());
            inputDisplay.setSelection(inputDisplay.getText().length());
            return true;
        });
        historyItemListView.setOnItemLongClickListener((parent, view, position, id) -> {
            ListItem longClickedItem = itemsList.get(position);

            inputDisplay.setText(inputDisplay.getText().toString() + longClickedItem.getTitle());
            inputDisplay.setSelection(inputDisplay.getText().length());
            return true;
        });

        onHistoryListItemChange();

        btnHyp.setOnClickListener(view -> bottomSheetDialog.show());
        btnPowerM1.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            if (inputDisplay.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.if_calc_nan), Toast.LENGTH_SHORT).show();
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "^(-1)");
                    inputDisplay.setSelection(cursorPosition + 5);
                }
            }
        });
        sinPowerM1.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×asin(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "asin(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        cosPowerM1.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×acos(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "acos(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        tanPowerM1.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×atan(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "atan(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        sinh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×sinh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "sinh(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        cosh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×cosh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "cosh(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        tanh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×tanh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "tanh(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        coth.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×coth(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "coth(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        sech.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×sech(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "sech(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        csch.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×csch(");
                    inputDisplay.setSelection(cursorPosition + 6);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "csch(");
                    inputDisplay.setSelection(cursorPosition + 5);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        arcSinh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×asinh(");
                    inputDisplay.setSelection(cursorPosition + 7);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "asinh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        arcCosh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×acosh(");
                    inputDisplay.setSelection(cursorPosition + 7);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "acosh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                    bottomSheetDialog.dismiss();
                }
            }
        });
        arcTanh.setOnClickListener(v -> {
            int cursorPosition = inputDisplay.getSelectionStart();
            Editable text = inputDisplay.getText();
            String t = inputDisplay.getText().toString();
            if (cursorPosition > 0 && endsWithPercent(t.substring(0, cursorPosition))) {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "×atanh(");
                    inputDisplay.setSelection(cursorPosition + 7);
                }
            } else {
                if (cursorPosition >= 0) {
                    text.insert(cursorPosition, "atanh(");
                    inputDisplay.setSelection(cursorPosition + 6);
                    bottomSheetDialog.dismiss();
                }
            }
        });
    }

    private void saveListToPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(itemsList);
        editor.putString(KEY_LIST, json);
        editor.apply();
    }

    private ArrayList<ListItem> loadListFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(KEY_LIST, null);

        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<ListItem>>() {}.getType();
            return gson.fromJson(json, type);
        }

        return new ArrayList<>();
    }

    private void onHistoryListItemChange() {
        if (itemListView.getAdapter() == null || itemListView.getAdapter().getCount() == 0) {
            itemListView.setVisibility(View.GONE);
            historyItemListView.setVisibility(View.GONE);
            noItemTextView.setVisibility(View.VISIBLE);
            historyNoItemTextView.setVisibility(View.VISIBLE);
            clearHistory.setEnabled(false);
            clearHistoryButton.setEnabled(false);
        } else {
            itemListView.setVisibility(View.VISIBLE);
            historyItemListView.setVisibility(View.VISIBLE);
            noItemTextView.setVisibility(View.GONE);
            historyNoItemTextView.setVisibility(View.GONE);
            clearHistory.setEnabled(true);
            clearHistoryButton.setEnabled(true);
            itemListView.smoothScrollToPosition(adapter.getCount() - 1);
            historyItemListView.smoothScrollToPosition(adapter.getCount() - 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.history) {
            historyBottomSheetDialog.show();
            return true;

        } else if (itemId == R.id.theme) {
            themeBottomSheetDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private double evaluateExpression(String expression) {
        Expression exp = new Expression(expression);
        return exp.calculate();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void attachTouchHapticRecursively(ViewGroup container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);

            if (child instanceof ViewGroup) {
                attachTouchHapticRecursively((ViewGroup) child);
            } else if (child.isClickable()) {
                child.setOnTouchListener((v, event) -> {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        v.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
                    }
                    return false;
                });
            }
        }
    }

    private boolean endsWithPercent(String text) {
        return text.endsWith("%");
    }
}