package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int topicIndex = getIntent().getIntExtra("topic_index", 0);

        // The three resource arrays use the same topic order.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] content = getResources().getStringArray(R.array.string_array_content);
        String[] images = getResources().getStringArray(R.array.string_array_images);
        String[] topics = {"Facilities", "Events", "Clubs", "Support"};

        TextView topicView = findViewById(R.id.detail_topic);
        TextView titleView = findViewById(R.id.detail_title);
        TextView contentView = findViewById(R.id.detail_content);
        ImageView imageView = findViewById(R.id.detail_image);

        topicView.setText(topics[topicIndex]);
        titleView.setText(titles[topicIndex]);
        contentView.setText(content[topicIndex]);

        int imageResource = getResources().getIdentifier(
                images[topicIndex].trim(), "drawable", getPackageName());
        imageView.setImageResource(imageResource);
    }
}
