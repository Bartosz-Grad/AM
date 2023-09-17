package com.example.egzaminlistview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(dataList);
        recyclerView.setAdapter(adapter);

        adapter.addItem("Zakupy: chleb, masło, ser");
        adapter.addItem("Do zrobienia: obiad, umyć podłogi");
        adapter.addItem("Weekend: kino, spacer z psem");
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText editText = findViewById(R.id.textInputEditText);
                String newItem = editText.getText().toString();
                if (!newItem.isEmpty()) {
                    adapter.addItem(newItem);
                    editText.getText().clear();
                }
            }
        });
    }
}