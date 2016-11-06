package app.com.example.android.popularmoviesstage1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState==null)
        {   getSupportFragmentManager().beginTransaction().add(R.id.fragment,new MGridFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        String sort=preferences.getString(SpKeys.SORT_KEY,"0");
        switch(sort)
        {   case "0":   toolbar.setTitle(getResources().getStringArray(R.array.sort_name)[0]);
            break;

            case "1":   toolbar.setTitle(getResources().getStringArray(R.array.sort_name)[1]);
                break;
        }
        setSupportActionBar(toolbar);
    }
}
