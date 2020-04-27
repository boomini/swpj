package com.example.jumi.merona;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private Activity m_activity;
    private ArrayList<Item> arr;
    public List_Adapter(Activity act, ArrayList<Item> arr_item) {
        this.m_activity = act;
        arr = arr_item;
        mInflater = (LayoutInflater)m_activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arr.size();
    }
    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }
    public long getItemId(int position){
        return position;
    }
    //position은 arraylist에 들어갈 아이템의 위치
    //
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            int res = 0;
            res = com.example.jumi.merona.R.layout.list_item;
            convertView = mInflater.inflate(res, parent, false);
        }
        TextView mtitle = (TextView)convertView.findViewById(R.id.item_title);
        TextView mstart = (TextView)convertView.findViewById(R.id.item_start);
        TextView marrive = (TextView)convertView.findViewById(R.id.item_arrive);
        TextView mdate = (TextView)convertView.findViewById(R.id.item_date);
        TextView mwriter = (TextView)convertView.findViewById(R.id.item_writer);
        TextView marrive_detail = (TextView)convertView.findViewById(R.id.item_arrivedetail);
        TextView mprice = (TextView)convertView.findViewById(R.id.item_price);
        LinearLayout layout_view =  (LinearLayout)convertView.findViewById(R.id.vi_view);
        Button ok = (Button)convertView.findViewById(R.id.item_ok);
        mtitle.setText(arr.get(position).Title);
        mstart.setText(arr.get(position).Start);
        marrive.setText(arr.get(position).Arrive);
        mdate.setText(arr.get(position).Date);
        mwriter.setText(arr.get(position).Writer);
        marrive_detail.setText(arr.get(position).Arrive_detail);
        mprice.setText(String.valueOf(arr.get(position).Price));
        /*	버튼에 이벤트처리를 하기위해선 setTag를 이용해서 사용할 수 있습니다.
         *
         * 	Button btn 가 있다면, btn.setTag(position)을 활용해서 각 버튼들의 이벤트처리를 할 수 있습니다.
         */
        ok.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                GoIntent(position);
               // Toast.makeText(this, "수락되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    public void GoIntent(int a){
        Intent intent = new Intent(m_activity, MainActivity.class);
        //putExtra 로 선택한 아이템의 정보를 인텐트로 넘겨 줄 수 있다.
        intent.putExtra("TITLE", arr.get(a).Title);
        intent.putExtra("START", arr.get(a).Start);
        intent.putExtra("ARRIVE", arr.get(a).Arrive);
        intent.putExtra("DATE", arr.get(a).Date);
        intent.putExtra("WRITER", arr.get(a).Writer);
        intent.putExtra("ArriveDetail",arr.get(a).Arrive_detail);
        intent.putExtra("PRICE",arr.get(a).Price);
        m_activity.startActivity(intent);
    }
}
