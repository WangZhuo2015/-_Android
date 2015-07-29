package com.example.wangzhuo.myapplication2015729;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;



public class MainActivity extends ActionBarActivity {


    public void Calc(View view){
            EditText TextX_a=(EditText)findViewById(R.id.Xa);
            EditText TextY_a=(EditText)findViewById(R.id.Ya);
            EditText TextX_b=(EditText)findViewById(R.id.Xb);
            EditText TextY_b=(EditText)findViewById(R.id.Yb);
            Double deltaX, deltaY, distance, angle;
            Double X_a=Double.parseDouble(TextX_a.getText().toString().trim());
            Double Y_a=Double.parseDouble(TextY_a.getText().toString().trim());
            Double X_b = Double.parseDouble(TextX_b.getText().toString().trim());
            Double Y_b=Double.parseDouble(TextY_b.getText().toString().trim());
            TextView distanceResult=(TextView)findViewById(R.id.distanceDisplay);
            TextView angleResult=(TextView)findViewById(R.id.angelDisplay);
            TextView quadrantText=(TextView)findViewById(R.id.quadrantDisplay);


        try{
            Quadrant quadrant = Quadrant.一;
            deltaX = X_b - X_a;
            deltaY = Y_b - Y_a;
            distance = Math.sqrt(Math.pow(deltaX, 2) +Math.pow(deltaY, 2));
            angle = Math.atan(Math.abs(deltaY / deltaX));
            if (deltaX < 0 && deltaY > 0)
            {
                angle = Math.PI - angle;
                quadrant = Quadrant.二;
            }
            else if (deltaX < 0 && deltaY < 0)
            {
                angle = Math.PI + angle;
                quadrant = Quadrant.三;
            }
            else if (deltaX > 0 && deltaY < 0)
            {
                angle = 2 * Math.PI - angle;
                quadrant = Quadrant.四;
            }

            angle = (angle / Math.PI) * 180;

            double degree, minute, second;
            degree = Math.floor(angle);
            minute= Math.floor((angle - degree) * 60);
            second = Math.floor((((angle - degree) * 60) - minute) * 60);


            distanceResult.setText("距离:" + String.format("%.4f", distance));
            angleResult.setText("角度:" + String.format("%.0f", degree)+"°"+String.format("%.0f", minute)+"\""+String.format("%.0f", second)+"'");
            quadrantText.setText("象限:第" + quadrant.toString() + "象限");

        }
        catch (Exception exp){
            distanceResult.setText(exp.getMessage());
            angleResult.setText("");
            quadrantText.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
