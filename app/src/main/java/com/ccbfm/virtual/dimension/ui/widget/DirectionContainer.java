package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.Direction;
import com.ccbfm.virtual.dimension.model.ui.Scene;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;
import com.ccbfm.virtual.dimension.utils.LogUtils;

public class DirectionContainer extends Container<Direction> {
    private static final String TAG = "FixedBodyContainer";
    private static final boolean DEBUG = true;

    private Text[][] mDirectionTexts;

    public DirectionContainer(@NonNull Context context) {
        super(context);
    }

    public DirectionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        int cx = mWidthPixels >> 2;
        int cy = mHeightPixels >> 2;

        int px = cx >> 2;
        int py = cy >> 2;

        int cellX = ModelConfig.Cell.COLUMN;
        int cellY = ModelConfig.Cell.ROW;

        mDirectionTexts = new Text[cellY][cellX];
        try {
            for (int i = 0; i < cellY; i++) {
                for (int j = 0; j < cellX; j++) {
                    Text direction = new Text(context).setBorder();
                    direction.setGravity(Gravity.CENTER);
                    direction.setText("");
                    LayoutParams directionLp = new LayoutParams(cx, cy);
                    directionLp.topMargin = py + (py + cy) * i;
                    directionLp.leftMargin = px + (px + cx) * j;
                    addView(direction, directionLp);
                    direction.setVisibility(INVISIBLE);
                    direction.setOnClickListener(this);

                    mDirectionTexts[i][j] = direction;
                }
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, "Throwable-=", th, DEBUG);
        }
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(2, ColorConfig.CInt.C000000));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected void liveDataResult(Direction data) {
        super.liveDataResult(data);

        int cellX = ModelConfig.Cell.COLUMN;
        int cellY = ModelConfig.Cell.ROW;

        Scene[][] scenes = null;
        if (data != null) {
            scenes = data.getScenes();
        }

        for (int i = 0; i < cellY; i++) {
            for (int j = 0; j < cellX; j++) {
                Scene scene = null;
                if (scenes != null) {
                    scene = scenes[i][j];
                }
                if (scene != null) {
                    mDirectionTexts[i][j].setVisibility(VISIBLE);
                    mDirectionTexts[i][j].setText(scene.getName());
                    mDirectionTexts[i][j].setTag(scene);
                } else {
                    //mDirectionTexts[i][j].setText("");
                    mDirectionTexts[i][j].setVisibility(INVISIBLE);
                }
            }
        }
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.DIRECTION;
    }
}
