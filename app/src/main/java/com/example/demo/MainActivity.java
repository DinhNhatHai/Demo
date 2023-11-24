package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextName = findViewById(R.id.e1);
        final EditText editTextMSSV = findViewById(R.id.e2);
        final EditText editTextAge = findViewById(R.id.e3);
        final RadioGroup radioGroupGender = findViewById(R.id.rg);
        final CheckBox checkBoxFootball = findViewById(R.id.c1);
        final CheckBox checkBoxGaming = findViewById(R.id.c2);
        Button btnSubmit = findViewById(R.id.bl);
        final TextView textViewResult = findViewById(R.id.t1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ các thành phần UI
                String name = editTextName.getText().toString();
                String mssv = editTextMSSV.getText().toString();
                String age = editTextAge.getText().toString();
                String gender = getSelectedGender();
                String sothich = "";
                boolean likesFootball = checkBoxFootball.isChecked();
                boolean likesGaming = checkBoxGaming.isChecked();
                if (likesFootball && likesGaming) {
                    sothich = "Bóng Đá, Chơi Game";
                }
                else if (likesGaming) {
                    sothich = "Chơi Game";
                } else if (likesFootball) {
                    sothich = "Bóng Đá";
                } else {
                    sothich = "Không có";
                }
                // Hiển thị kết quả
                String result = "Tên: " + name + "\nMSSV: " + mssv + "\nTuổi: " + age +
                        "\nGiới Tính: " + gender + "\nSở Thích: " + sothich ;
                textViewResult.setText(result);
            }
        });
    }

    private String getSelectedGender() {
        RadioGroup radioGroup = findViewById(R.id.rg);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.r1) {
            return "Nam";
        } else if (selectedId == R.id.r2) {
            return "Nữ";
        } else {
            return "Không rõ";
        }
    }
}