package com.aust.healthmate;

import android.widget.ImageView;

public class ExampleItem {
    private int mImageResource,nImageResource;
    private String mText,nText,pText;


    public ExampleItem(int imageResource1,int imageResource2,String text1,String text2,String text3){

          mImageResource=imageResource1;
          nImageResource=imageResource2;
          mText=text1;
          nText=text2;
          pText=text3;
    }
    public int getImageResource()
    {
        return mImageResource;
    }
    public int getmImageResource2(){
        return nImageResource;
    }
    public String getnText()
    {
        return nText;
    }
    public String getmText()
    {
        return mText;
    }
    public String getpText()
    {
        return pText;
    }
}
