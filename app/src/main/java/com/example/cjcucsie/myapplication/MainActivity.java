package com.example.cjcucsie.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private Button btnMain;
    private RecyclerView mRecyclerView;
    public MyAdapter mMyAdapter;
    private int count=0;
    private String u="true";
    public ArrayList<String> data;
    Toolbar mActionBarToolbar;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_main,null);
        final EditText editText = (EditText) mView.findViewById(R.id.task_name);
        Button submit = (Button) mView.findViewById(R.id.submit);
        Button cancel = (Button) mView.findViewById(R.id.cancel);
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(!editText.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    mMyAdapter.add_new_task(editText.getText().toString());
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "項目名不可空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        return super.onOptionsItemSelected(item);
    }
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            data.add(Integer.toString(i));
        }
        mMyAdapter = new MyAdapter(data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
    }
}