package name.vicentvalls.riskofwargames_wh;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


public class Welcome extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button goMenu = (Button) findViewById(R.id.menu_button);
        goMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Has pulsado Aceptar!", Toast.LENGTH_SHORT).show();
            }
        });

        Button btUno= (Button) findViewById(R.id.menu_button);
        btUno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s = new String();

        switch (v.getId()) {
            case R.id.menu_button:
        }
        Toast.makeText(getBaseContext(), "Has pulsado " + s, Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_leadership:
                Toast.makeText(getBaseContext(), "Has pulsado Liderazgo!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Welcome.this,LeadershipTest.class);
                startActivity(i);
                break;
            case R.id.action_charge:
                Toast.makeText(getBaseContext(), "Has pulsado Carga!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_magic:
                Toast.makeText(getBaseContext(), "Has pulsado Magia!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_close:
                Toast.makeText(getBaseContext(), "Has pulsado Cerrar!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
