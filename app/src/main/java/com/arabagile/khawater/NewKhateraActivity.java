package com.arabagile.khawater;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewKhateraActivity extends AppCompatActivity {

    @BindView(R.id.editText) EditText etKhatera;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.container) CoordinatorLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_khatera);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_khatera, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {

            // Back to previous view للرجوع للواجهة السابقة
            case android.R.id.home:
                onBackPressed();
                return true;

            // Add new Khatera لإضافة الخاطرة
            case R.id.action_add:
                return addKhatera();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

        String khatera = etKhatera.getText().toString();

        if (!khatera.isEmpty()) {
            new AlertDialog.Builder(NewKhateraActivity.this)
                    .setTitle(R.string.cancel_khatera)
                    .setMessage(R.string.cancel_khatera_confirmation)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel it
                            cancelKhatera();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();            return;
        }

        super.onBackPressed();
    }

    public void cancelKhatera() {
        super.onBackPressed();
    }

    private boolean addKhatera() {
        String khatera = etKhatera.getText().toString();

        if (khatera.isEmpty()) {
            Snackbar.make(container, R.string.warn_empty_khatera, Snackbar.LENGTH_LONG).show();
            return false;
        }

        Toast.makeText(NewKhateraActivity.this, "Adding Khatera", Toast.LENGTH_SHORT).show();
        finish();
        return true;
    }
}
