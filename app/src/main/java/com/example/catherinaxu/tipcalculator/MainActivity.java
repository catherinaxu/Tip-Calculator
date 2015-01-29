package com.example.catherinaxu.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RatingBar;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

    private double tipPercentage = 0.15;
    private double totalBill = 0;

    /* resets fields */
    public void clickReset(View view) {
        tipPercentage = 0.15;
        totalBill = 0;
        float initNumberStars = 0.0f;
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);
        bar.setRating(initNumberStars);
        TextView finalMessage = (TextView) findViewById(R.id.final_amount);
        finalMessage.setText("");
        EditText bill = (EditText)findViewById(R.id.editText);
        bill.setText("");
    }

    /* calculates proper tip percentage value based on mood */
    public void clickSubmitRatingButton(View view) {
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);
        double rating = bar.getRating();
        if (rating >= 0 && rating <=2) {
            tipPercentage = 0.1;
        } else if (rating > 2 && rating <= 4) {
            tipPercentage = 0.15;
        } else if (rating > 4 && rating <= 5) {
            tipPercentage = 0.2;
        }
        Toast.makeText(this, "Mood submitted!", Toast.LENGTH_SHORT).show();
    }

    /* calculates total tip value */
    public void clickSubmitBillButton(View view) {
        EditText bill = (EditText)findViewById(R.id.editText);
        if (bill.getText().toString().trim().length() == 0) {
            totalBill = 0;
        } else {
            totalBill = Double.parseDouble(bill.getText().toString());
        }
        double tip = (1 + tipPercentage) * totalBill;
        TextView finalMessage = (TextView) findViewById(R.id.final_amount);
        finalMessage.setText("Final payment amount: $" + String.format("%.2f", tip));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
