package com.example.commidternmaithieutin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.commidternmaithieutin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int finalSocre;
    private List<String> list;
    private MyViewModel model;
    private List<String> newlist;
    private ActivityMainBinding binding;

    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(MyViewModel.class);
        list = new ArrayList<>();
        newlist = new ArrayList<>();

        list.add("Thu do viet nam la ha noi: ");
        list.add("1 + 1 = 3 la ket qua dung hay sai:");
        list.add("Tia chớp được nhìn thấy trước khi nó được nghe thấy vì ánh sáng truyền nhanh hơn âm thanh.");
        list.add("Melbourne là thủ đô của Úc.");
        list.add("Núi Phú Sĩ là ngọn núi cao nhất ở Nhật Bản.");
        list.add("Bóng đèn là phát minh của Thomas Edison.");
        list.add("Google ban đầu được gọi là BackRub.");
        list.add("Hộp đen trong máy bay có màu đen");
        list.add("Cà chua là trái cây.");
        list.add("Bầu khí quyển của sao Thủy được tạo thành từ Carbon Dioxide");

        String question = list.get(currentIndex);
        binding.QuesText.setText(question);



        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.button2.setBackgroundColor(getResources().getColor(R.color.blue));
                if(currentIndex %2 == 0) {
                    String answer = list.get(currentIndex) + "  Corect";
                    newlist.add(answer);
                    finalSocre += 1;
                }else {
                    String answer = list.get(currentIndex) + "  Wrong";
                    newlist.add(answer);
                }
            }
        });


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.button3.setBackgroundColor(getResources().getColor(R.color.blue));
                if(currentIndex %2 != 0) {
                    String answer = list.get(currentIndex) + "  Corect";
                    newlist.add(answer);
                    finalSocre += 1;
                }else {
                    String answer = list.get(currentIndex) + "  Wrong";
                    newlist.add(answer);
                }
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.button2.setBackgroundColor(getResources().getColor(R.color.purple));
                binding.button3.setBackgroundColor(getResources().getColor(R.color.purple));
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = list.size() - 1;
                }
                String question = list.get(currentIndex);
                binding.QuesText.setText(question);
                binding.button2.setEnabled(true);
                binding.button3.setEnabled(true);
                binding.button5.setEnabled(true);
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.button2.setBackgroundColor(getResources().getColor(R.color.purple));
                binding.button3.setBackgroundColor(getResources().getColor(R.color.purple));
                currentIndex++;
                if (currentIndex >= list.size()) {
                    currentIndex = 0;
                    binding.QuesText.setText("The end of the question Pls submit");
                    binding.button2.setEnabled(false);
                    binding.button3.setEnabled(false);
                    binding.button5.setEnabled(false);
                }else{
                String question = list.get(currentIndex);
                binding.QuesText.setText(question);
                }
            }
        });

        binding.Btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putStringArrayListExtra("questionList", (ArrayList<String>) newlist);
                startActivity(intent);
            }
        });
    }
}