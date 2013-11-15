package com.qudgar.laundryday;

import android.content.Context;
import java.util.Calendar;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class ViewGrid extends View
{

    private Calendar rightNow = Calendar.getInstance();
	private final BookRoom book;
	DateList myDateList;
	
	private float width, height;
	private int selX, selY;
	
	private int myGridSizeX = 10;
	private int myGridSizeY = 7;
	
	private final Rect selRect = new Rect();
	
	public ViewGrid(Context context)
	{
		super(context);
		this.book = (BookRoom) context;
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	
	public void AddList(DateList aDateList)
	{
		myDateList = aDateList;
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		width = w/4;
		height = h/7;
		getRect(selX, selY, selRect);
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	private void getRect(int x, int y, Rect rect) 
	{
	      rect.set((int) (x * width), (int) (y * height), (int) (x * width + width), (int) (y * height + height));
	}

	 @Override
	   protected void onDraw(Canvas canvas) {
	      // Draw the background...
	      Paint background = new Paint();
	      background.setColor(getResources().getColor(R.color.white));

	      canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background480x800), 0, 0, null);
	      
	      // Draw the board...
	      
	      // Define colors for the grid lines
	      Paint dark = new Paint();
	      dark.setColor(getResources().getColor(R.color.white));

	      Paint hilite = new Paint();
	      hilite.setColor(getResources().getColor(R.color.red));

	      Paint light = new Paint();
	      light.setColor(getResources().getColor(R.color.line));

	      // Draw the minor grid lines
	      for (int i = 0; i < myGridSizeX; i++)
	      {
		     canvas.drawLine(0, i * height-1, getWidth(), i * height,light);
	         canvas.drawLine(0, i * height, getWidth(), i * height,light);
		     canvas.drawLine(0, i * height+1, getWidth(), i * height,light);
	         

	         canvas.drawLine(i * width-1, 0, i * width, getHeight(),light);
	         canvas.drawLine(i * width, 0, i * width, getHeight(),light);
	         canvas.drawLine(i * width+1, 0, i * width, getHeight(),light);
	      }


	      Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
	      foreground.setColor(getResources().getColor(
	            R.color.white));
	      foreground.setStyle(Style.FILL);
	      foreground.setTextSize(height * 0.25f);
	      //foreground.setTextScaleX(width / height);
	      foreground.setTextAlign(Paint.Align.LEFT);

	      // Draw the number in the center of the tile
	      FontMetrics fm = foreground.getFontMetrics();
	      // Centering in X: use alignment (and X at midpoint)
	      float x = width / 2;
	      // Centering in Y: measure ascent/descent first
	      float y = height / 2 - (fm.ascent + fm.descent) / 2;
	      
	      
	      for (int i = 0; i < myGridSizeX; i++)
	      {
	         for (int j = 0; j < myGridSizeY; j++)
	         {


	   	        foreground.setTextAlign(Paint.Align.LEFT);
		        canvas.drawText(GetCurrentDateDay(i) + "/" + GetCurrentMonth(), i* width + 5.0f, j * height + 25.0f, foreground);

			    foreground.setTextAlign(Paint.Align.RIGHT);
	            canvas.drawText(GetCurrentDay(i), i* width + 115.0f, j * height + 25.0f, foreground);

	  	      	foreground.setTextSize(height * 0.35f);

	  	      	foreground.setTextAlign(Paint.Align.CENTER);
	            canvas.drawText(GetTime(j), i* width + x, j * height + y + 15.0f, foreground);
	            
	            
	            
	            if (myDateList.GetDayandDate(i, j))
	            {
	  	      		foreground.setTextSize(height * 1.37f);
	  	      		foreground.setColor(getResources().getColor(R.color.red));

	  	      		foreground.setTextScaleX(1.55f);
	  	      		canvas.drawText("X", i * width + x, j * height + y + 40.0f, foreground);
	  	      		foreground.setTextScaleX(1);
	  	      		
	  	      		foreground.setColor(getResources().getColor(R.color.white));
	            }
	            
	            
  	      		foreground.setTextSize(height * 0.25f);
	  	      	
	  	      	
	  	      	
	  	      	
		        // Draw the selection...
		        Paint selected = new Paint();
		        selected.setColor(getResources().getColor(R.color.marked));
		        canvas.drawRect(selRect, selected);
			    invalidate(selRect);
	         }
	      }
	      
	      
	   }

	@Override
	   public boolean onTouchEvent(MotionEvent event) {
	      if (event.getAction() != MotionEvent.ACTION_DOWN)
	         return super.onTouchEvent(event);

	      select((int) (event.getX() / width),
	            (int) (event.getY() / height));
	          
	      return true;
	   }
	 
	 private void select(int x, int y)
	 {
	     invalidate(selRect);
	      selX = Math.min(Math.max(x, 0), myGridSizeX-1);
	      selY = Math.min(Math.max(y, 0), myGridSizeY-1);
	      getRect(selX, selY, selRect);
	      invalidate(selRect);
	      CurrentSelectedRect(selX, selY);
	   }
	 
	 
	 private void CurrentSelectedRect(int aSelX, int aSelY)
	 {
		 boolean tempBool = myDateList.GetDayandDate(aSelX, aSelY);
		 
		 if (tempBool == false)
		 {
			 myDateList.SetDayValue(aSelX, aSelY, true);
			 
			 String day = GetCurrentDay(aSelX);
			 String date = GetCurrentDateDay(aSelX) + "/" + GetCurrentMonth();
			 String pass = GetTime(aSelY);
			 
			 LocalData.GetInstance().SetBookedPass(day, date, pass);
		 }
		 else
		 {
			 // FUCK U!!!!
		 }
		 
	 }
	 
	 
	 private String GetCurrentDay(int aNewDay)
	 {
		  int temp = aNewDay + rightNow.get(Calendar.DAY_OF_WEEK);
	      
	      if (temp == 1) return "Sö";
	      if (temp == 2) return "Må";
	      if (temp == 3) return "Ti";
	      if (temp == 4) return "On";
	      if (temp == 5) return "To";
	      if (temp == 6) return "Fr";
	      if (temp == 7) return "Lö";
	      if (temp == 8) return "Sö";
	      if (temp == 9) return "Må";
	      if (temp == 10) return "Ti";
	      if (temp == 11) return "On";
	      if (temp == 12) return "To";
	      if (temp == 13) return "Fr";
	      if (temp == 14) return "Lö";
	      
	      return "XX";
	 }
	 
	 private String GetCurrentDateDay(int aNewDay)
	 {
		 int temp = aNewDay + rightNow.get(Calendar.DAY_OF_MONTH);
		 
		 return Integer.toString(temp);
	 }
	 
	 private String GetCurrentMonth()
	 {
		 int temp = 1 + rightNow.get(Calendar.MONTH);
		 return Integer.toString(temp);
		 
	 }
     
	 private String GetTime(int aID)
	 {
		 if (aID == 0) return "8-10";
		 if (aID == 1) return "10-12";
		 if (aID == 2) return "12-14";
		 if (aID == 3) return "14-16";
		 if (aID == 4) return "16-18";
		 if (aID == 5) return "18-20";
		 
		 return "20-22";
	 }
	
	
}
