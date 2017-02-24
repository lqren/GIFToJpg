package com.project.giftojpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.project.giftojpg.utils.GifDecoderUtils;

public class MainActivity extends AppCompatActivity {
    private GifDecoderUtils gifDecoder;
    private LinearLayout         mLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLl = (LinearLayout) findViewById(R.id.activity_main);
        showGif2();
    }
    void showGif2()
    {
        gifDecoder = new GifDecoderUtils();
        try {
            gifDecoder.read(this.getResources().openRawResource(R.raw.index));
            int size =gifDecoder.getFrameCount();
            for(int i=0;i<size;i++)
            {

                ImageView iv_image = new ImageView(this);
                iv_image.setPadding(5, 5, 5, 5);
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(500,500);
                iv_image.setLayoutParams(lparams);
                iv_image.setImageBitmap(gifDecoder.getFrame(i));
                mLl.addView(iv_image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
