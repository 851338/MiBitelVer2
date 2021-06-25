package com.example.mibitelver2.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.mibitelver2.R;
import com.example.mibitelver2.model.videoInfo.VideoLike;
import com.example.mibitelver2.retrofit.retrofitInterface.APIVideoInterface;
import com.example.mibitelver2.retrofit.RetrofitClient;
import com.example.mibitelver2.databinding.ActivityVideoBinding;
import com.example.mibitelver2.model.VideoUser;
import com.example.mibitelver2.model.videoInfo.VideoInfoData;
import com.example.mibitelver2.model.videoInfo.VideoInfo;
import com.example.mibitelver2.util.Constants;
import com.example.mibitelver2.view.viewmodel.VideoUserViewModel;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoActivity extends AppCompatActivity {

    private VideoInfo videoInfo;
    private VideoInfoData data;
    private String timeWatch;

    public static Intent newIntent(Context context, int videoId) {
        Intent i = new Intent(context, VideoActivity.class);
        i.putExtra(Constants.video_id, videoId);
        return i;
    }

    private int videoId;
    ImageView comment;
    PlayerView playerView;
    ProgressBar progressBar;
    SimpleExoPlayer simpleExoPlayer;
    String currentTime;
    int k = 1;
    VideoUser videoUser;
    VideoUserViewModel videoUserViewModel;
    private String linkVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        videoUser = new VideoUser(1, 20, 20, "tien", "ta la ngo xua tien dayhahahahah", "dsds", "Ngô Xuân Tiến");

        ActivityVideoBinding activityVideoBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_video);

        activityVideoBinding.setVideoActivity(this);
        activityVideoBinding.setLifecycleOwner(this);

        int id = getIntent().getIntExtra(Constants.video_id, 100);

        videoUserViewModel = new ViewModelProviders().of(this).get(VideoUserViewModel.class);
        videoUserViewModel.getVideoAccount(id);

        //Get video info: Like, watch later, time watched, duration...
        getVideoInfo();

        playerView = findViewById(R.id.play_video);
        progressBar = findViewById(R.id.progress_bar);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LoadControl loadControl = new DefaultLoadControl();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelector trackSelector = new DefaultTrackSelector(
                new AdaptiveTrackSelection.Factory(bandwidthMeter));
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(
                VideoActivity.this, trackSelector, loadControl);
        DefaultHttpDataSourceFactory factory
                = new DefaultHttpDataSourceFactory("exoplayer_video");
        ExtractorsFactory extractorsFactory
                = new DefaultExtractorsFactory();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            changes();
            Uri videoUrl = Uri.parse(linkVideo);

            //Convert time watched to milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            TimeZone gmt = TimeZone.getTimeZone("GMT");
            sdf.setTimeZone(gmt);
            Date date = new Date();

            if (timeWatch == null)
                timeWatch = "00:00:00";
            try {
                date = sdf.parse(timeWatch);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            assert date != null;
            Log.e("Time watched", String.valueOf(date));
            long tw = date.getTime();
            Log.e("Time watched",
                    String.format(Locale.getDefault(), "%d", tw));

            MediaSource mediaSource = buildMediaSource(videoUrl);
            playerView.setPlayer(simpleExoPlayer);
            playerView.setKeepScreenOn(true);
            simpleExoPlayer.prepare(mediaSource);
            simpleExoPlayer.setPlayWhenReady(true);

            //lay thoi gian da xem video truoc khi thoat ra
            long currentPosition = simpleExoPlayer.getCurrentPosition();
            currentTime = String.format(Locale.getDefault(), "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(currentPosition),
                    TimeUnit.MILLISECONDS.toMinutes(currentPosition) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currentPosition)),
                    // The change is in this line
                    TimeUnit.MILLISECONDS.toSeconds(currentPosition) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPosition)));

            //chay den doan video lan truoc da xem den
            simpleExoPlayer.seekTo(tw);

        }, 500);

        simpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.VISIBLE);
                } else if (playbackState == Player.STATE_READY) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }

        });

        CheckBox favorite = findViewById(R.id.activity_video_favorite);
        favorite.setOnCheckedChangeListener((buttonView, isChecked) -> setVideoLike());

    }

    private void changes() {
        videoUserViewModel.videoAcount12.observe(this,
                videoAccount -> setM(videoAccount.getData().getLinkVideo()));
    }

    public void setM(String m) {
        linkVideo = m;
    }

//    public void setUser(){
//
//    }

    private MediaSource buildMediaSource(Uri uri) {
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(this, "exoplayer-codelab");
        return new HlsMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
    }

    public void clickComment() {
        com.example.mibitelver2.view.MyBottonSheetDialogFragment sheetDialogFragment = com.example.mibitelver2.view.MyBottonSheetDialogFragment.newInstance();
        sheetDialogFragment.show(getSupportFragmentManager(), sheetDialogFragment.getTag());
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.getPlaybackState();
    }

    public void clickBack() {
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.getPlaybackState();
        setVideoInfo();
        k = 2;

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.getPlaybackState();

    }

    //Them ham get Thong tin video (Like, xem sau, thoi gian da xem, vv)
    private void getVideoInfo() {
        CheckBox favorite = findViewById(R.id.activity_video_favorite);
        CheckBox watchLater = findViewById(R.id.activity_video_watchLater);

        int videoId = getIntent().getIntExtra(Constants.video_id, 0);

        data = new VideoInfoData();
        APIVideoInterface api = RetrofitClient.getClient()
                .create(APIVideoInterface.class);
        Call<VideoInfo> videoInfo = api.getVideoInfo(videoId, 2);
        videoInfo.enqueue(new Callback<VideoInfo>() {
            @Override
            public void onResponse(@NotNull Call<VideoInfo> call,
                                   @NotNull Response<VideoInfo> response) {
                assert response.body() != null;
                data = response.body().getData();
                if(data.isLiked())
                favorite.setChecked(data.isLiked());
                watchLater.setChecked(data.isWatch());
                timeWatch = data.getTimeWatch();
                Log.e("Success", "Get video info success");
            }

            @Override
            public void onFailure(@NotNull Call<VideoInfo> call, @NotNull Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }

    //Ham set thong tin video
    private void setVideoInfo() {
        int videoId = getIntent().getIntExtra(Constants.video_id, 0);
        CheckBox favorite = findViewById(R.id.activity_video_favorite);
        CheckBox watchLater = findViewById(R.id.activity_video_watchLater);

        data = new VideoInfoData();
        data.setLiked(favorite.isChecked());
        data.setWatch(watchLater.isChecked());

        APIVideoInterface api = RetrofitClient.getClient()
                .create(APIVideoInterface.class);

        api.setVideoInfo(2, 1, data)
               .enqueue(new Callback<VideoInfoData>() {
                   @Override
                   public void onResponse(@NotNull Call<VideoInfoData> call,
                                          @NotNull Response<VideoInfoData> response) {
                       Log.e("Success", "PUT");
                   }

                   @Override
                   public void onFailure(@NotNull Call<VideoInfoData> call, @NotNull Throwable t) {
                        Log.e("Failed", t.toString());
                   }
               });
    }

    //Ham like video
    private void setVideoLike() {
        int videoId = getIntent().getIntExtra(Constants.video_id, 0);
        CheckBox favorite = findViewById(R.id.activity_video_favorite);
        VideoLike videoLike = new VideoLike(favorite.isChecked(), videoId, 2);
        APIVideoInterface api = RetrofitClient.getClient().create(APIVideoInterface.class);
        Call<VideoLike> setLike = api.setLikeVideo(videoLike);
        setLike.enqueue(new Callback<VideoLike>() {
            @Override
            public void onResponse(@NotNull Call<VideoLike> call,
                                   @NotNull Response<VideoLike> response) {
                
            }

            @Override
            public void onFailure(@NotNull Call<VideoLike> call, @NotNull Throwable t) {
                Log.e("Like video", t.toString());
            }
        });
    }
}