package com.xys.study.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.WindowManager;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static int targetNum = 0;
    static int times = 0;
    static boolean level = false;
    static boolean hard = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        final TextView tvHint = findViewById(R.id.hint);
        final EditText etNum = findViewById(R.id.inputNum);
        final TextView tvTimes = findViewById(R.id.times);

        Button getNumBtn = findViewById(R.id.getNumBtn);
        getNumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random r = new Random();
                targetNum = r.nextInt(100)+1;
                times = 0;
                hard = level;
                tvHint.setText("数字已生成");
                etNum.setText("");
                tvTimes.setText("本回合已猜次数：0");
                Log.d("MainActivity","new_num");
            }
        });

        Button levelBtn = findViewById(R.id.levelBtn);
        levelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                level = !level;
            }
        });

        Button guessbtn = findViewById(R.id.guessBtn);
        guessbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("MainActivity","guess_num");
                if(targetNum==0)
                {
                    tvHint.setText("请先生成一个数字");
                    return;
                }
                try{
                    int num = Integer.parseInt(etNum.getText().toString());
                    if(num<1||num>100)
                        tvHint.setText("所输入整数超过范围，请重新输入");
                    else{
                        if(num==targetNum){
                            tvHint.setText(new StringBuilder("恭喜你猜对了，答案为"+num));
                            targetNum = 0;
                            return;
                        }
                        else if(num<targetNum)
                            tvHint.setText(new StringBuilder("所输入整数为"+num+"，小于目标"));
                        else
                            tvHint.setText(new StringBuilder("所输入整数为"+num+"，大于目标"));
                        times++;
                        if(hard&&times>=6)
                        {
                            tvHint.setText(new StringBuilder("次数已满，您失败了。答案是" + targetNum));
                            targetNum = 0;
                        }
                        tvTimes.setText(new StringBuilder("本回合已猜次数："+times));
                    }
                }
                catch(Exception e){
                    Log.d("MainActivity","wrong_input");
                    tvHint.setText("输入内容不是整数，请重新输入");
                }
                finally{
                    etNum.setText("");
                }
            }
        });

        Button btn1 = findViewById(R.id.one);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"1"));
            }
        });
        Button btn2 = findViewById(R.id.two);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"2"));
            }
        });
        Button btn3 = findViewById(R.id.three);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"3"));
            }
        });
        Button btn4 = findViewById(R.id.four);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"4"));
            }
        });
        Button btn5 = findViewById(R.id.five);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"5"));
            }
        });
        Button btn6 = findViewById(R.id.six);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"6"));
            }
        });
        Button btn7 = findViewById(R.id.seven);
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"7"));
            }
        });
        Button btn8 = findViewById(R.id.eight);
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"8"));
            }
        });
        Button btn9 = findViewById(R.id.nine);
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"9"));
            }
        });
        Button btn0 = findViewById(R.id.zero);
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etNum.setText(new StringBuilder(etNum.getText().toString()+"0"));
            }
        });
        Button btnDelete = findViewById(R.id.delete);
        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = etNum.getText().toString();
                if(!text.equals(""))
                    etNum.setText(text.substring(0,text.length()-1));
            }
        });
    }
}