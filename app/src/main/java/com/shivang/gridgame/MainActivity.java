package com.shivang.gridgame;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeplayer=0;
    int[][] a;
     int i,j,x,y,fl;
    GridLayout gl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl=(GridLayout)findViewById(R.id.grlay);
        a=new int[9][9];
        for(i=0;i<9;i++)
            for(j=0;j<9;j++)
                a[i][j]=1;
    }

    public void compute(int s)
    {

        x=(s/10)-1;
        y=(s%10)-1;

    }

    public void block()
    {
        a[x][y]=0;
        if(x!=0)
            a[x-1][y]=0;
        if(y!=0)
            a[x][y-1]=0;
        if(x!=0 && y!=0)
            a[x-1][y-1]=0;

        if(x!=8)
            a[x+1][y]=0;
        if(y!=8)
            a[x][y+1]=0;
        if(x!=8 && y!=8)
            a[x+1][y+1]=0;

        if(x!=0 && y!=8)
            a[x-1][y+1]=0;

        if(x!=8 && y!=0)
            a[x+1][y-1]=0;



    }



    public  void onClick(View view)
    {
        ImageView Counter=(ImageView)view;
        TextView tv2=(TextView)findViewById(R.id.textView);
        compute(Integer.parseInt(Counter.getTag().toString()));
        if(a[x][y]==1) {

            if (activeplayer == 0) {
                tv2.setText("Player Blue choose your box");

                tv2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
                block();
                Counter.setImageResource(R.color.colorAccent);

                gl.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                activeplayer = 1;


            } else {

                tv2.setText("Player Pink choose your box");
                tv2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                block();
                activeplayer = 0;
                Counter.setImageResource(R.color.colorPrimary);
                gl.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

            }
        }
        fl=0;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(a[i][j]==1)
                {
                    fl=1;
                    break;
                }
            }
            if(fl==1)
                break;
        }


        if(fl==0) {
            if(activeplayer==0)
            {
                tv2.setText("You win Neele");
                tv2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));

            }
            else
            {
                tv2.setText("You win Pinky");
                tv2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));

            }

        }


    }
}
