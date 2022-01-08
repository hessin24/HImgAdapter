package de.hessin.android.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;

public class HSimpleImgAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final ArrayList<Bitmap> images;
    private final RequiredIDs iDs;
    public HSimpleImgAdapter(Context context, RequiredIDs iDs, ArrayList<Bitmap> images){
        this.inflater = LayoutInflater.from(context);
        this.images = images;
        this.iDs = iDs;

    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Bitmap getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View cv, ViewGroup parent) {
        HVHolder hvHolder;
        if (cv == null){
            hvHolder = new HVHolder();
            cv = inflater.inflate(iDs.layoutResID,parent,false);
            hvHolder.iv = (ImageView) cv.findViewById(iDs.ivID);
            cv.setTag(hvHolder);
        }else {
            hvHolder = (HVHolder) cv.getTag();
        }
        hvHolder.iv.setImageBitmap(images.get(position));
        return cv;
    }

    public static class RequiredIDs{
         public int layoutResID;
          public int ivID;
          public RequiredIDs(int layoutResID, int ivID){
              this.layoutResID = layoutResID;
             this.ivID = ivID;
          }
    }
    public static class HVHolder {
        public ImageView iv;
    }
}
