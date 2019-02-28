package com.ansari.recyviewnjson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ansari on 6/9/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    private Context context;
  //  ImageLoader imageLoader;


    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final ListItem myList = listItems.get(position);

        holder.heading.setText(myList.getHeading());
        holder.description.setText(myList.getDesc());
        Picasso.with(context)
                .load(myList.getImage_url())
                .into(holder.imageView);

       /* holder.heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item Clicked : " + myList.getHeading() + "postion : " +
                        position, Toast.LENGTH_LONG).show();
            }
        });*/

     holder.linearLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "linear layout Clicked : "+ myList.getSpouse() + " postion : " +
                      position ,Toast.LENGTH_LONG).show();
             Intent i = new Intent(context,DispalyData.class);
              String myheading = myList.getHeading();
              String desc= myList.getDesc();
              String myurl = myList.getImage_url();
              String spouse = myList.getSpouse();
              Bundle b = new Bundle();
              b.putInt("postion",position);
              b.putString("heading",myheading);
              b.putString("desc",desc);
              b.putString("url",myurl);
              b.putString("spouse",spouse);
              i.putExtras(b);
                v.getContext().startActivity(i);
          }
      });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView heading, description;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            heading = (TextView) itemView.findViewById(R.id.textviewHeading);
            description = (TextView) itemView.findViewById(R.id.textviewDescription);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.MyLLitem);

        }
    }
}
