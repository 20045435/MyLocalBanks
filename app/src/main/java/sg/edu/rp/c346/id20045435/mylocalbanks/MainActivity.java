package sg.edu.rp.c346.id20045435.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, getString(R.string.website));
        menu.add(0,1,1, getString(R.string.contact));
        menu.add(0,2,2, getString(R.string.favourite));

        if (v == tvDBS) {
            wordClicked = getString(R.string.dbs);
        }
        else if (v == tvOCBC){
            wordClicked = getString(R.string.ocbc);
        }
        else if (v == tvUOB) {
            wordClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.EnglishSelection) {
            Toast.makeText(MainActivity.this, getString(R.string.englishselected), Toast.LENGTH_SHORT).show();
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }
        else if (item.getItemId() == R.id.ChineseSelection) {
            Toast.makeText(MainActivity.this, getString(R.string.chineseselected), Toast.LENGTH_SHORT).show();
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.URLdbs)));
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.URLocbc)));
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.URLuob)));
                startActivity(intentCall);
            }
        }

        else if (item.getItemId() == 1) {
            if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.teldbs)));
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.telocbc)));
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.teluob)));
                startActivity(intentCall);
            }
        }

        else if (item.getItemId() == 2) {
            if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
                if (tvDBS.getCurrentTextColor() == Color.WHITE) {
                    tvDBS.setTextColor(Color.YELLOW);
                }
                else if (tvDBS.getCurrentTextColor() == Color.YELLOW) {
                    tvDBS.setTextColor(Color.WHITE);
                }
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                if (tvOCBC.getCurrentTextColor() == Color.WHITE) {
                    tvOCBC.setTextColor(Color.BLUE);
                }
                else if (tvOCBC.getCurrentTextColor() == Color.BLUE) {
                    tvOCBC.setTextColor(Color.WHITE);
                }
            }
            else if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
                if (tvUOB.getCurrentTextColor() == Color.WHITE) {
                    tvUOB.setTextColor(Color.RED);
                }
                else if (tvUOB.getCurrentTextColor() == Color.RED) {
                    tvUOB.setTextColor(Color.WHITE);
                }
            }
        }

        return super.onContextItemSelected(item);
    }
}