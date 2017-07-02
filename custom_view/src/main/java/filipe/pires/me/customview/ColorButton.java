package filipe.pires.me.customview;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class ColorButton extends AppCompatButton {

    public static final int BUTTON_TYPE_BLUE = 0;
    public static final int BUTTON_TYPE_RED = 1;

    public ColorButton(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        setLayout(context);

        if (isInEditMode()) {
            setBackground(ContextCompat.getDrawable(context, R.drawable.button_blue_selector));
            return;
        }

        setBackground(context, attributeSet);
    }

    private void setBackground(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ColorButton);
        try {
            int type = typedArray.getInt(R.styleable.ColorButton_colorButtonType, BUTTON_TYPE_BLUE);
            if (type == BUTTON_TYPE_BLUE) {
                setBackground(ContextCompat.getDrawable(context, R.drawable.button_blue_selector));
            } else {
                setBackground(ContextCompat.getDrawable(context, R.drawable.button_red_selector));
            }
        } finally {
            typedArray.recycle();
        }
    }

    private void setLayout(Context context) {
        setAllCaps(true);
        setTextColor(ContextCompat.getColor(context, R.color.white));
        setMinHeight(getResources().getDimensionPixelOffset(R.dimen.grid_4X));
        setMinWidth(getResources().getDimensionPixelOffset(R.dimen.grid_7X));
        int padding = getResources().getDimensionPixelOffset(R.dimen.grid_2X);
        setPadding(padding, padding, padding, padding);
    }

    public ColorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ColorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }
}