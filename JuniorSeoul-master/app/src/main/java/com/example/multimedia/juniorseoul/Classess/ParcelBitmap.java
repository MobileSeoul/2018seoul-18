package com.example.multimedia.juniorseoul.Classess;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelBitmap implements Parcelable {
    private Bitmap mSrc = null;

    public ParcelBitmap(Bitmap src) {
        if( src != null )
            mSrc = Bitmap.createBitmap(src);
    }

    public final Bitmap getBitmap(){
        return this.mSrc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if( mSrc != null )
            this.mSrc.writeToParcel(dest , flags);
    }
    public static final Parcelable.Creator<ParcelBitmap> CREATOR = new Creator<ParcelBitmap>() {
        public ParcelBitmap createFromParcel(Parcel source) {
            ParcelBitmap Result = new ParcelBitmap(null);
            try
            {
                Result.mSrc = (Bitmap)Bitmap.CREATOR.createFromParcel(source);
            }catch( Exception e )
            {
                e.printStackTrace();
            }
            return Result;
        }
        public ParcelBitmap[] newArray(int size) {
            return new ParcelBitmap[size];
        }

    };

}
