package temple.edu;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity  {
    Spinner spinner;   //creating a spinner object
    String[] myColor = {"White", "Red", "Blue", "Black", "Yellow", "Green", "Gray", "Cyan", "Magenta"};  //creatting array list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myColor);

        // specify the layout to use when the list of choices appears
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(myAdapter);

        ColorAdapter ArrayAdapter = new ColorAdapter(this, myColor);
        spinner.setAdapter(ArrayAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                View mainll = findViewById(R.id.main_layout);
                mainll.setBackgroundColor(Color.parseColor(color));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }
}


