package com.example.adapter;

import java.util.ArrayList;

import com.example.bmgl.Zwxx;
import com.example.sqlite2.DBHelper2;
import com.example.test1.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter5 extends BaseAdapter{    
    private Context context;    
    private ArrayList<String> text;  
    private DBHelper2 Dao2;
    public Adapter5(Context context,ArrayList<String> text){    
        this.context = context;    
        this.text=text;    
    }    
    @Override    
    public int getCount() {    
        // TODO Auto-generated method stub    
        return text.size();    
    }    
    @Override    
    public Object getItem(int position) {    
        // TODO Auto-generated method stub    
        return text.get(position);    
    }    
    @Override    
    public long getItemId(int position) {    
        // TODO Auto-generated method stub    
        return position;    
    }    
    @Override    
    public View getView(int position, View convertView, ViewGroup parent) {    
        // TODO Auto-generated method stub    
        final int index=position;    
        View view=convertView;    
        if(view==null){    
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);    
            view=inflater.inflate(R.layout.row_simple_list_item_1, null);    
        }    
        final TextView textView=(TextView)view.findViewById(R.id.simple_item_1);    
        textView.setText(text.get(position));    
        final ImageView imageView=(ImageView)view.findViewById(R.id.simple_item_3);    
        imageView.setBackgroundResource(android.R.drawable.ic_dialog_info);   
        imageView.setTag(position);  
        imageView.setOnClickListener(new OnClickListener() {    
            @Override    
            public void onClick(View v) {    
                // TODO Auto-generated method stub    
            	Intent intent = new Intent(context, Zwxx.class);
            	intent.putExtra("zw", textView.getText().toString());
		        context.startActivity(intent);
            }    
        });
        final ImageView imageView2=(ImageView)view.findViewById(R.id.simple_item_2);    
        imageView2.setBackgroundResource(android.R.drawable.ic_delete);   
        imageView2.setTag(position);    
        imageView2.setOnClickListener(new OnClickListener() {      
            @Override    
            public void onClick(View v) {    
                // TODO Auto-generated method stub   
            	Dao2=new DBHelper2(context);
            	Dao2.dbDeleteZw(textView.getText().toString());
                text.remove(index);
                notifyDataSetChanged();    
                Toast.makeText(context,"ɾ��"+textView.getText().toString()+ "�ɹ�", Toast.LENGTH_SHORT).show();    
            }    
        });    
        return view;    
    }    
} 