package ws.munday.slidingmenu;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

public class ScrollToAnimation extends Animation {

	private int mEnd;
	private int mStart;
	private int mChange;
	
	private View mView;
	
	public ScrollToAnimation(View v, int marginStart, int marginEnd, Interpolator i){

		mStart = marginStart;
		mEnd = marginEnd;
		mView = v;
		
		mChange = mEnd - mStart;
		setInterpolator(i);
		
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {

		float change = mChange * interpolatedTime;
		
		mView.scrollTo((int) -(mStart + change), 0);
		
		super.applyTransformation(interpolatedTime, t);
	}

}
