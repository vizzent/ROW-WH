package name.vicentvalls.riskofwargames_wh;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RadioGroup;
import name.vicentvalls.riskofwargames_wh.Probability;


public class LeadershipTest extends Activity {

    public LinearLayout result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leadership_test);

        result = (LinearLayout) findViewById(R.id.result_layout);

    }

    public void calcular(View button)
    {
        EditText leadershipInput   = (EditText)findViewById(R.id.input_leadership);
        CheckBox addDiceCBox = (CheckBox)findViewById(R.id.input_add_dice);
        RadioButton radioMinVal = (RadioButton)findViewById(R.id.input_add_dice_min);
        boolean addDice = addDiceCBox.isChecked();
        boolean getMinor = radioMinVal.isChecked();
        int leaderValue = Integer.parseInt(leadershipInput.getText().toString());

        Toast.makeText(getBaseContext(), "Procesando...", Toast.LENGTH_SHORT).show();

        if (result.getVisibility() != View.VISIBLE)
        {
            int percent = Probability.leadershipProbability(leaderValue, addDice, getMinor);
            String strResultFormat = getResources().getString(R.string.leadership_result);
            String strResultMsg = String.format(strResultFormat, percent);
            TextView txtCambiado = (TextView)findViewById(R.id.result);
            txtCambiado.setText(strResultMsg);
            result.setVisibility(View.VISIBLE);
        }
    }

    public void showRadioGroup(View checkBox) {
        boolean checked = ((CheckBox) checkBox).isChecked();
        View options = findViewById(R.id.leadership_option);
        if (checked) {
            options.setVisibility(View.VISIBLE);
        } else {
            options.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.leadership_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
