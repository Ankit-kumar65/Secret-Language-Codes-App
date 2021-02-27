package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class vicode extends AppCompatActivity {

    private TextView tvHasilPlain, tvHasilKey, tvHasilEncrypt, tvHasilText, tvHasilDecrypt, tvHasilDecryptText;
    private EditText edPlainText, edKey;
    private Button btnEncrypt, btnDecrypt;
    private final String am = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] anarry = am.toCharArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vicode);

        init();
    }

    private void init() {
        tvHasilPlain = findViewById(R.id.tv_hasil_plain);
        tvHasilKey = findViewById(R.id.tv_hasil_key);
        tvHasilEncrypt = findViewById(R.id.tv_hasil_encrypt);
        tvHasilText = findViewById(R.id.tv_hasil_text);
        tvHasilDecrypt = findViewById(R.id.tv_hasil_decrypt);
        tvHasilDecryptText = findViewById(R.id.tv_hasil_decrypt_text);
        edPlainText = findViewById(R.id.ed_plain_text);
        edKey = findViewById(R.id.ed_key_text);
        btnEncrypt = findViewById(R.id.btn_encrypt);
        btnDecrypt = findViewById(R.id.btn_decrypt);

        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHasilPlain.setText("Text message coordinate: " + getString(R.string.index_plain_text) + Arrays.toString(getIndex()));
                tvHasilKey.setText("Key coordinate: " + getString(R.string.index_key_text) + Arrays.toString(getIndexKey()));
                tvHasilEncrypt.setText("Encrypt text coordinate: " + getString(R.string.index_hasil_encrypt) + Arrays.toString(encryptFunction()));

                convertToString();


            }
        });


        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHasilPlain.setText("Text message coordinate: " + getString(R.string.index_plain_text) + Arrays.toString(getIndex()));
                tvHasilKey.setText("Key coordinate: " + getString(R.string.index_key_text) + Arrays.toString(getIndexKey()));
                tvHasilEncrypt.setText("Decrypt text coordinate: " + getString(R.string.index_hasil_encrypt) + Arrays.toString(decryptFunction2()));

                convertToStringDecrypt2();


            }
        });
    }


    private int[] getIndex() {
        String temp1 = edPlainText.getText().toString().toUpperCase().trim();
        char[] pxArray = temp1.toCharArray();
        int z = 0;
        int[] temp = new int[temp1.length()];
        for (int i = 0; i < temp1.length(); i++) {
            int a = 0;
            while (anarry[a] != pxArray[i]) {
                a++;
            }
            temp[z] = a;
            z++;
        }
        return temp;
    }

    public int[] getIndexKey() {
        String key = edKey.getText().toString().toUpperCase().trim();
        int z = 0;
        char[] keyArray = key.toCharArray();
        int[] temp = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            int a = 0;
            while (anarry[a] != keyArray[i]) {
                a++;
            }
            temp[z] = a;
            z++;
        }
        return temp;
    }

    public int[] encryptFunction() {
        int temp[] = new int[getIndex().length];
        int a = 0;
        int b = getIndexKey().length;
        int z = getIndex().length;
        for (int i = 0; i < getIndex().length; i++) {
            try {
                if (a % b == 0) {
                    a = 0;
                    temp[i] = (getIndex()[i] + getIndexKey()[a]) % 26;
                    a++;
                } else {
                    temp[i] = (getIndex()[i] + getIndexKey()[a]) % 26;
                    a++;
                }
            } catch (Exception e) {
                tvHasilText.setText("Not possible");
                e.printStackTrace();
            }
        }
        return temp;
    }


    public int[] decryptFunction2() {
        int temp[] = new int[getIndex().length];
        int a = 0;
        try {
            for (int i = 0; i < getIndex().length; i++) {
                if (a % getIndexKey().length == 0) {
                    a = 0;
                    temp[i] = getIndex()[i] - getIndexKey()[a];
                    if (temp[i] < 0) {
                        temp[i] += 26;
                    }
                    a++;
                } else {
                    temp[i] = getIndex()[i] - getIndexKey()[a];
                    if (temp[i] < 0) {
                        temp[i] += 26;
                    }
                    a++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void convertToStringDecrypt2() {
        int temp = 0;
        char[] tempL = new char[decryptFunction2().length];
        try {
            for (int i = 0; i < decryptFunction2().length; i++) {
                if (decryptFunction2()[i] < 25) {
                    temp = decryptFunction2()[i];
                    tempL[i] = am.charAt(temp);
                    String a = String.valueOf(tempL);
                    tvHasilText.setText("Decrypt text: " + a);
                } else {
                    temp = decryptFunction2()[i];
                    tempL[i] = am.charAt(temp % 25);
                    String a = String.valueOf(tempL);
                    tvHasilText.setText("Decrypt text: " + a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void convertToString() {
        int temp = 0;
        char[] tempL = new char[encryptFunction().length];
        try {
            for (int i = 0; i < encryptFunction().length; i++) {
                if (encryptFunction()[i] < 26) {
                    temp = encryptFunction()[i];
                    tempL[i] = am.charAt(temp);
                    String a = String.valueOf(tempL);
                    tvHasilText.setText("Encrypt text: " + a);
                } else {
                    temp = encryptFunction()[i];
                    tempL[i] = am.charAt(temp % 26);
                    String a = String.valueOf(tempL);
                    tvHasilText.setText("Encrypt text: " + a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}







