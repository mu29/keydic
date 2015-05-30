package nimbus.keydic;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class BookmarkActivity extends ActionBarActivity {

    ListView listView;
    WordItemAdapter arrayAdapter;
    String[] keyValue;
    String test[] = {"1","3","5","31","3","200","49"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        Word.init(this);

        SharedPreferences prefs = getSharedPreferences("bookmark", MODE_PRIVATE);
        String result = prefs.getString("bookmark", "0"); //키값, 디폴트값
        keyValue = result.split(",");

        listView = (ListView)findViewById(R.id.lv_bookmark);
        arrayAdapter = new WordItemAdapter();
        listView.setAdapter(arrayAdapter);

        for (String key : test) {
            Word word = Word.get(Integer.parseInt(key));

            String left = word.getLeft();
            String right = word.getRight();
            String center = word.getCenter();
            String example = word.getExample();

            arrayAdapter.add(left +" " + center +" " + right + "\n" + example);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bookmark, menu);
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