package com.example.oayubi.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    String item;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        item = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("position",0);
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        etNewItem.setText(item);
        etNewItem.setSelection(etNewItem.getText().length());
    }

    public void saveNewItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String itemText = etNewItem.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("item",itemText);
        intent.putExtra("position",position);
        setResult(RESULT_OK, intent);
        finish();
    }

}
