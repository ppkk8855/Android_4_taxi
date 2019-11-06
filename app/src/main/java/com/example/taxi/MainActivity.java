package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText StartPrice;
    private EditText M;
    private EditText AddMoney;
    private EditText Distance;
    private TextView TotalMoney;
    private Button   Count;
    int total_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartPrice=findViewById(R.id.edt1);
        M=findViewById(R.id.edt2);
        AddMoney=findViewById(R.id.edt3);
        Distance=findViewById(R.id.edt4);
        TotalMoney=findViewById(R.id.tv9);
        Count=findViewById(R.id.btn1);

        Count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StartPrice.getText().toString().matches("")
                        ||M.getText().toString().matches("")
                        ||AddMoney.getText().toString().matches("")
                        ||Distance.getText().toString().matches(""))
                {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不能空白", Toast.LENGTH_LONG);
                    toast.show();
                }

                else{
                    int StartPrice_count = Integer.parseInt(StartPrice.getText().toString());
                    int M_cont = Integer.parseInt(M.getText().toString());
                    int AddMoney_cont = Integer.parseInt(AddMoney.getText().toString());
                    int Distance_cont = Integer.parseInt(Distance.getText().toString());

                    int total_time = Distance_cont / M_cont;
                    if (Distance_cont % M_cont != 0)
                        total_time++;
                    total_count = StartPrice_count + total_time * AddMoney_cont;
                    TotalMoney.setText(String.valueOf(total_count)  +"元");




                }





            }
        });



    }
}
