package com.nv.secretlanguagecodes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;


public class morsecode extends AppCompatActivity {



    private TextView txt;
    private TextView result;
    private Button toMorseBtn;
    private Button toAlphaBtn;
    private  Button b111;

    public static class MorseCode {

        static String[] ALPHA = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", ",", "?",
                ".", "'"};
        static String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--",
                "..--..", ".-.-.-", ".----.", };

        public static HashMap<String, String> ALPHA_TO_MORSE = new HashMap<>();
        public static HashMap<String, String> MORSE_TO_ALPHA = new HashMap<>();

        static {
            for (int i = 0; i < ALPHA.length  &&  i < MORSE.length; i++) {
                ALPHA_TO_MORSE.put(ALPHA[i], MORSE[i]);
                MORSE_TO_ALPHA.put(MORSE[i], ALPHA[i]);
            }
        }

        public static String morseToAlpha(String morseCode) {
            StringBuilder builder = new StringBuilder();
            String[] words = morseCode.trim().split("   ");

            for (String word : words) {
                for (String letter : word.split(" ")) {
                    String alpha = MORSE_TO_ALPHA.get(letter);
                    builder.append(alpha);
                }

                builder.append(" ");
            }

            return builder.toString().toUpperCase();
        }

        public static String alphaToMorse(String englishCode) {
            StringBuilder builder = new StringBuilder();
            String[] words = englishCode.trim().split(" ");

            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    String morse = ALPHA_TO_MORSE.get(word.substring(i, i + 1).toLowerCase());
                    builder.append(morse).append(" ");
                }

                builder.append("  ");
            }

            return builder.toString();
        }

    }










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morsecode);



        txt = (TextView) findViewById(R.id.txt);
        result = (TextView) findViewById(R.id.result);
        toMorseBtn = (Button) findViewById(R.id.toMorseBtn);
        toAlphaBtn = (Button) findViewById(R.id.toAlphaBtn);
        b111 = (Button) findViewById(R.id.b23);

        toMorseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtToConvert = txt.getText().toString();
                String convertedTxt = MorseCode.alphaToMorse(txtToConvert);
                result.setText(convertedTxt);
            }
        });

        toAlphaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtToConvert = txt.getText().toString();
                String convertedTxt = MorseCode.morseToAlpha(txtToConvert);
                result.setText(convertedTxt);
            }
        });

        b111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cliphboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("text",result.getText().toString());
                cliphboard.setPrimaryClip(clip);
                Toast.makeText(morsecode.this , "copied", Toast.LENGTH_SHORT).show();



            }
        });



    }
}






