package info.devexchanges.stackview;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StackView stackView;
    private final int[] IMAGE_IDs = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5, R.drawable.image_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stackView = (StackView) findViewById(R.id.stack_view);

        ArrayList<StackItem> stackItems = new ArrayList<>();
        for (int imageId : IMAGE_IDs) {
            String name = getResources().getResourceEntryName(imageId);
            stackItems.add(new StackItem(imageId, name));
        }

        StackAdapter stackAdapter = new StackAdapter(this, R.layout.item_stack, stackItems);
        stackView.setAdapter(stackAdapter);
    }
}
