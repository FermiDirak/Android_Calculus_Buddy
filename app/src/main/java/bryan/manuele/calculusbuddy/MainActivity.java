package bryan.manuele.calculusbuddy;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView learnTextView;
    TextView testTextView;
    TextView correctionsTextView;

    LinearLayout holder1;
    LinearLayout holder2;
    LinearLayout holder3;

    LayoutInflater subMenuInflater;
    int selected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subMenuInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        selected = -1;

        learnTextView = (TextView) findViewById(R.id.learnButton);
        testTextView = (TextView) findViewById(R.id.testButton);
        correctionsTextView = (TextView) findViewById(R.id.correctionsButton);

        holder1 = (LinearLayout) findViewById(R.id.holder1);
        holder2 = (LinearLayout) findViewById(R.id.holder2);
        holder3 = (LinearLayout) findViewById(R.id.holder3);

        learnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(0);
            }
        });

        testTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(1);
            }
        });

        correctionsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(2);
            }
        });
    }

    public void setSelected(int i) {
        switch (selected) {
            case -1:
                break;
            case 0:
                holder1.removeAllViews();
                break;
            case 1:
                holder2.removeAllViews();
                break;
            case 2:
                holder3.removeAllViews();
                break;
        }

        if (selected == i) {
            selected = -1;
            return;
        }

        switch (i) {
            case 0:
                holder1.addView(subMenuInflater.inflate(R.layout.activity_main_sub_menu, null));
                break;
            case 1:
                holder2.addView(subMenuInflater.inflate(R.layout.activity_main_sub_menu, null));
                break;
            case 2:
                holder3.addView(subMenuInflater.inflate(R.layout.activity_main_sub_menu, null));
                break;
        }

        selected = i;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
