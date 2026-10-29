package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/** Displays the selected topic using the supplied text and image resources. */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Keep content clear of the status and navigation bars.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Read MainActivity's topic index; default to Facilities when it is absent.
        int topicIndex = getIntent().getIntExtra("topic_index", 0);

        // Matching entries share an index, so no if or switch is needed.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] content = getResources().getStringArray(R.array.string_array_content);
        String[] images = getResources().getStringArray(R.array.string_array_images);

        // Short names belong in the banner; resource titles are the longer headings.
        String[] topics = {"Facilities", "Events", "Clubs", "Support"};

        TextView topicView = findViewById(R.id.detail_topic);
        TextView titleView = findViewById(R.id.detail_title);
        TextView contentView = findViewById(R.id.detail_content);
        ImageView imageView = findViewById(R.id.detail_image);

        topicView.setText(topics[topicIndex]);
        titleView.setText(titles[topicIndex]);
        contentView.setText(content[topicIndex]);

        // Resolve the drawable name supplied in arrays.xml to a resource ID.
        int imageResource = getResources().getIdentifier(
                images[topicIndex].trim(), "drawable", getPackageName());
        imageView.setImageResource(imageResource);
    }
}
