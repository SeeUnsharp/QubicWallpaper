package iota.qubicwallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class Preview extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        Intent intent = new Intent();

        String packageName = getApplicationContext().getPackageName();

        intent.setAction(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(packageName,
                (new StringBuilder(String.valueOf(packageName))).append(".QubicWallpaperService").toString()));

        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        finish();
    }

}
