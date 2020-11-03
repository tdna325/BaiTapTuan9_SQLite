package com.example.tuan9_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private EditText etID;
    private EditText etName;
    private EditText etToan;
    private EditText etLy;
    private EditText etHoa;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        initListener();
    }



    private void initView() {
        btnThem = (Button) findViewById(R.id.bt_them);
        btnSua = (Button) findViewById(R.id.bt_sua);
        btnXoa = (Button) findViewById(R.id.bt_xoa);
        etID = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etToan = (EditText) findViewById(R.id.et_toan);
        etLy = (EditText) findViewById(R.id.et_ly);
        etHoa = (EditText) findViewById(R.id.et_hoa);

    }
    private void initListener() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String ly = etLy.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl = myDatabase.insertData(name,toan,ly,hoa);
                if(bl)
                {
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Insert fail", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bl = myDatabase.updateData(etID.getText().toString(),etName.getText().toString(),etToan.getText().toString(),etLy.getText().toString(),etHoa.getText().toString());
                if(bl)
                {
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bl = myDatabase.deleteData(etID.getText().toString());
                if(bl)
                {
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}