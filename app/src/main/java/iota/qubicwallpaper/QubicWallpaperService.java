package iota.qubicwallpaper;

import android.media.MediaPlayer;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

public class QubicWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new QubicWallpaperEngine();
    }

    private class QubicWallpaperEngine extends Engine {

        MediaPlayer mediaPlayer;

        @Override
        public void onVisibilityChanged(boolean visible) {
            if (visible) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.qubic);
            mediaPlayer.setSurface(holder.getSurface());

            try {

                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0, 0);
                mediaPlayer.start();

            } catch (IllegalStateException e) {
                Log.e(e.getClass().getName(), "Exception: "+Log.getStackTraceString(e));
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

