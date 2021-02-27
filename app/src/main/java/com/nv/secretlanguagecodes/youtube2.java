package com.nv.secretlanguagecodes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class youtube2 extends AppCompatActivity {
    VideoView videoView;
    ImageView thumbnailView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube2);

        videoView=findViewById(R.id.videoView2);
        thumbnailView=findViewById(R.id.image2);

        MediaController mm=new MediaController(this);
        mm.setAnchorView(videoView);
        Uri uri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/morse-code-alphabet.appspot.com/o/Morse%20Code%20Numbers%20(online-video-cutter.com).mp4?alt=media&token=8cc15763-d9a0-4277-b072-cbc8b1081680");
        videoView.setMediaController(mm);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                thumbnailView.setVisibility(View.GONE);
                //you can Hide progress dialog here when video is start playing;

            }
        });

    }
}
