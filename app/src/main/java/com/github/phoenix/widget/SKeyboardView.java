package com.github.phoenix.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import com.github.phoenix.R;
import com.github.phoenix.utils.ResUtil;

import java.util.List;

/**
 * 自定义键盘，按要求绘制键盘背景，图标，文本等
 *
 * @author Phoenix
 * @date 2016-12-7 17:08
 */
public class SKeyboardView extends KeyboardView {
    private Context context;
    private Rect rect;
    private Paint paint;

    private int keyboardType = -1;

    public SKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
//        initSKeyboardView();
    }

    public SKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
//        initSKeyboardView();
    }

    /**
     * 初始化画笔等
     */
    private void initSKeyboardView() {
        rect = new Rect();

        paint = new Paint();
        paint.setTextSize(70);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (getKeyboard() == null) {
//            return;
//        }
//        List<Keyboard.Key> keys = getKeyboard().getKeys();
//
//        if (keyboardType == 0) {// 数字键盘
//            drawKeyboardNumber(keys, canvas);
//        } else if (keyboardType == 1) {// 英文键盘
//            drawKeyboardEnglish(keys, canvas);
//        }
    }

    /**
     * 绘制数字键盘
     *
     * @param keys
     * @param canvas
     */
    private void drawKeyboardNumber(List<Keyboard.Key> keys, Canvas canvas) {
        for (Keyboard.Key key : keys) {
            if (key.codes[0] == -5) {//删除键
                drawKeyBackground(R.drawable.img_edit_clear, canvas, key);
            }
        }
    }

    /**
     * 绘制英文键盘
     *
     * @param keys
     * @param canvas
     */
    private void drawKeyboardEnglish(List<Keyboard.Key> keys, Canvas canvas) {
        for (Keyboard.Key key : keys) {
            if (key.codes[0] == -5) {//删除键
                drawKeyBackground(R.drawable.img_edit_clear, canvas, key);
            }
            if (key.codes[0] == -1) {//大小写切换
                drawKeyBackground(R.drawable.img_edit_clear, canvas, key);
            }
            if (key.codes[0] == 32) {//space

            }
            if (key.codes[0] == -4) {//完成

            }
        }
    }

    /**
     * 设置当前键盘标识 0：数字键盘；1：英文键盘
     *
     * @param keyboardType
     */
    public void setCurrentKeyboard(int keyboardType) {
        this.keyboardType = keyboardType;
        invalidate();
    }

    /**
     * 绘制键盘key的背景
     *
     * @param drawableId 将要绘制上去的图标
     * @param canvas
     * @param key        需要绘制的键
     */
    private void drawKeyBackground(int drawableId, Canvas canvas, Keyboard.Key key) {
        Drawable npd = ResUtil.getDrawable(drawableId);
        int[] drawableState = key.getCurrentDrawableState();
        if (key.codes[0] != 0) {
            npd.setState(drawableState);
        }
        npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        npd.draw(canvas);
    }

    /**
     * 绘制字体
     *
     * @param canvas
     * @param key
     */
    private void drawKeyText(Canvas canvas, Keyboard.Key key) {
        if (keyboardType == 0) {
            if (key.label != null) {
                paint.getTextBounds(key.label.toString(), 0, key.label.toString().length(), rect);
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (key.y + key.height / 2) + rect.height() / 2, paint);
            }
        } else if (keyboardType == 1) {
            if (key.label != null) {
                paint.getTextBounds(key.label.toString(), 0, key.label.toString().length(), rect);
                canvas.drawText(key.label.toString(), key.x + (key.width / 2), (key.y + key.height / 2) + rect.height() / 2, paint);
            }
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
