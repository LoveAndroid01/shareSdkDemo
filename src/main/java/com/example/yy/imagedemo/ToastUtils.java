package com.example.yy.imagedemo;

import android.content.Context;
import android.widget.Toast;

/**
 * @author x250
 *         工具类，避免多页toast长时间显示
 */
public class ToastUtils {

    private static Toast mToast;

    /**
     * @param ctx 上下文
     * @param msg 显示的字符串信息
     */
    public static void show(Context ctx, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * @param ctx
     * @param msgId
     */
    public static void show(Context ctx, int msgId) {
        show(ctx, ctx.getString(msgId));
    }

}
