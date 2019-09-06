package emerge.project.mrsolution_admin.ui.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/**
 * Created by attract on 3/12/15.
 */

public class MontserratRegularAutoComlete extends AutoCompleteTextView {
    public MontserratRegularAutoComlete(Context context) {
        super(context);
        init();
    }

    public MontserratRegularAutoComlete(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratRegularAutoComlete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.otf");
        setTypeface(tf);
    }
}
