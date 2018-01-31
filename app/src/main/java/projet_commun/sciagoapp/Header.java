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
        float top1=5, right1=20, left1=140, bottom1=80;
        float epaisseur1=120, epaisseur2=60.0f;
        float imgLeft=500;
        float nomAppX=650, nomAppY=50, txtY=nomAppY+50;
        /*pinceau.setColor(0xff1128e3);
        canvas.drawRect(top1, right1, left1, bottom1, pinceau);

        pinceau.setColor(Color.MAGENTA);
        pinceau.setStyle(Paint.Style.STROKE);
        pinceau.setStrokeWidth(epaisseur);
        canvas.drawCircle(circleX, circleY, circleRadius, pinceau);     */

        //Paint pinceau2 = new Paint();
        /*
        pinceau.setStrokeWidth(epaisseur2);
        //pinceau2.setFakeBoldText(true);*/
        //pinceau.setTextSize(TypedValue.COMPLEX_UNIT_DIP);
        pinceau.setStrokeWidth(epaisseur1);
        pinceau.setColor(Color.WHITE);
        pinceau.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(nomApp, nomAppX, nomAppY, pinceau);
        pinceau.setTypeface(Typeface.DEFAULT);
        //pinceau.setStrokeWidth(epaisseur2);
        pinceau.setTextSize(epaisseur2);
        //canvas.setDensity();
        canvas.drawText(slogan, nomAppX, txtY, pinceau);
        canvas.drawBitmap(img, imgLeft, top1, pinceau);
    }
}
