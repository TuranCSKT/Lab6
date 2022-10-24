package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab6.TextCounter;

public class MainActivity extends AppCompatActivity {

    Spinner spCountingOption;
    EditText etInput;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCountingOption = findViewById(R.id.spCountingOption);
        this.etInput = findViewById(R.id.etInput);
        this.tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.counter_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCountingOption.setAdapter(adapter);
    }

    public void onBtnClick(View view) {
        String phrase = this.etInput.getText().toString();

        if (TextUtils.isEmpty(phrase)) {
            Toast.makeText(MainActivity.this,
                    "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,
                    "Proceed..",
                    Toast.LENGTH_SHORT).show();

            if(spCountingOption.getSelectedItem().toString().equals("Chars")) {
                int charsCount = TextCounter.getCharsCount(phrase);
                String formattedResult = String.valueOf(charsCount);
                this.tvResult.setText(formattedResult);
            }

            else {
                int wordsCount = TextCounter.getWordsCount(phrase);
                String formattedResult = String.valueOf(wordsCount);
                this.tvResult.setText(formattedResult);
            }

        }
    }
}