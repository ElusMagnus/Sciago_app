package projet_commun.sciagoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

//import timotheeb.sciagoapp.R;

/**
 * Created by tim-b on 29/01/2018.
 */

public class Header extends View{
    private String nomApp, slogan;
    private Bitmap img;

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);

        nomApp = this.getResources().getString(R.string.app_name);
        slogan = this.getResources().getString(R.string.slogan_sciago);
        img = BitmapFactory.decodeResource(
                this.getResources(),
                R.drawable.logo_app);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint pinceau = new Paint();
        float top1=5, left1=140, bottom1=80;
        float epaisseur1=45.0f, epaisseur2=35.0f;
        float imgLeft=350;
        float nomAppX=430, nomAppY=90, txtX=nomAppX+100, txtY=nomAppY+60;

        pinceau.setColor(Color.WHITE);
        pinceau.setTypeface(Typeface.DEFAULT_BOLD);
        pinceau.setTextSize(epaisseur1);
        canvas.drawText(nomApp, txtX, nomAppY, pinceau);

        Paint pinceau2 = new Paint();
        pinceau2.setColor(Color.WHITE);
        pinceau2.setTypeface(Typeface.DEFAULT);
        pinceau2.setTextSize(epaisseur2);
        canvas.drawText(slogan, txtX, txtY, pinceau2);
        canvas.drawBitmap(img, imgLeft, top1, pinceau);
    }
}
