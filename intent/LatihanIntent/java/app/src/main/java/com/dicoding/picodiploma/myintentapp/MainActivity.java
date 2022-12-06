package com.dicoding.picodiploma.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == MoveForResultActivity.RESULT_CODE && result.getData() != null) {
                    int selectedValue = result.getData().getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                    tvResult.setText(String.format("Hasil : %s", selectedValue));
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_activity) {
            /*
            Intent untuk memulai activity baru
            */
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_move_activity_data) {
            /*
            Intent untuk mengirimkan data ke activity lain
            */
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
            startActivity(moveWithDataIntent);
        } else if (v.getId() == R.id.btn_move_activity_object) {
            /*
            Intent untuk mengirimkan object ke activity lain, perlu diingat bahwa object Person adalah parcelable
            */
            Person person = new Person();
            person.setName("DicodingAcademy");
            person.setAge(5);
            person.setEmail("academy@dicoding.com");
            person.setCity("Bandung");

            Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
            startActivity(moveWithObjectIntent);
        } else if (v.getId() == R.id.btn_dial_number) {
            /*
            Intent action untuk menjalankan action dial
            */
            String phoneNumber = "081210841382";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        } else if (v.getId() == R.id.btn_move_for_result) {
            /*
            Intent for result bermanfaat ketika kita ingin mendapatkan nilai balikan dari activity lainnya
            Perhatikan bahwa kita mengirimkan intent beserta REQUEST_CODE
            */
            Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
            resultLauncher.launch(moveForResultIntent);
        }
    }
}
