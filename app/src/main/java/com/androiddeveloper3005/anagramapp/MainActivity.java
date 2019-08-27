package com.androiddeveloper3005.anagramapp;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    TextView tv_info,tv_word;

    EditText et_guess;

    Button b_check,b_new;
    Random r;
    String currentWord;
    String[] dictionary = {
            "Orange",
            "two",
            "light",
            "flower",
            "motive",
            "speed",
            "red",
            "black",
            "name",
            "education",
            "tour",
            "flight",
            "free",
            "sixty",
            "save",
            "eight",
            "night",
            "top",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);
        b_new = (Button) findViewById(R.id.b_new);
        r = new Random();
        newGame();

        b_check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_guess.getText().toString().equalsIgnoreCase(currentWord)) {
                    tv_info.setText("Awesome!");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);

                }
                else {
                    tv_info.setText("Try Again???");

                }

            }
        });

        b_new.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();

            }
        });




    }

    private String suffelword(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String Letter: letters){
            shuffled += Letter ;
        }
        return shuffled;
    }
    private void newGame() {
        currentWord = dictionary[r.nextInt(dictionary.length)];
        tv_word.setText(suffelword(currentWord));

        et_guess.setText("");
        b_new.setEnabled(false);
        b_check.setEnabled(true);
    }

}



