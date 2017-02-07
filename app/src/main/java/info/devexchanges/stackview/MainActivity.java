package info.devexchanges.stackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.StackView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] IMAGE_IDs = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5, R.drawable.image_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackView stackView = (StackView) findViewById(R.id.stack_view);
        stackView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Main", "i =  "+ i + " l= " + l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<StackItem> stackItems = new ArrayList<>();
        for (int imageId : IMAGE_IDs) {
            String name = getResources().getResourceEntryName(imageId);
            stackItems.add(new StackItem(imageId, name));
        }

        StackAdapter stackAdapter = new StackAdapter(this, R.layout.item_stack, stackItems);
        stackView.setAdapter(stackAdapter);
    }
}
