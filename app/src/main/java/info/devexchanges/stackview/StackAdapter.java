package info.devexchanges.stackview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StackAdapter extends ArrayAdapter<StackItem> {

    private List<StackItem> items;
    private Context context;

    public StackAdapter(Context context, int textViewResourceId, List<StackItem> objects) {
        super(context, textViewResourceId, objects);
        this.items = objects;
        this.context = context;
    }

    @NonNull
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder; //initialize a null ViewHolder object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_stack, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }
        StackItem stackItem = items.get(position);

        //set stack item data to views
        holder.image.setImageResource(stackItem.getDrawableId());
        holder.imageName.setText(stackItem.getImageName());

        return convertView;
    }

    private class ViewHolder {
        private TextView imageName;
        private ImageView image;

        public ViewHolder(View view) {
            this.image = (ImageView) view.findViewById(R.id.imageView);
            this.imageName = (TextView) view.findViewById(R.id.textView);
        }
    }
}