package com.example.yy.imagedemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.*;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * 分享的自定义弹层
 * Created by yy on 2017/10/31.
 */

public class ShareDialog {
    private Dialog mDialog;
    //取消分享
    private TextView txtCancle;
    private DialogInterface.OnClickListener mOnCancleListener;
    //微信分享
    private LinearLayout mWeChatShare;
    private DialogInterface.OnClickListener mOnWeChatShareListener;
    //qq分享
    private LinearLayout mQQShare;
    private DialogInterface.OnClickListener mQQShareListener;
    //微博分享
    private LinearLayout mWeiBoShare;
    private DialogInterface.OnClickListener mWeiBoShareListener;
    //微博分享
    private LinearLayout mQzoneShare;
    private DialogInterface.OnClickListener mQzoneShareListener;
    //微信朋友圈分享
    private LinearLayout mWeChatFriendShare;
    private DialogInterface.OnClickListener mOnWeChatFriendShareListener;
    //复制链接
    private LinearLayout mcopylineShare;
    private DialogInterface.OnClickListener mcopylineShareListener;
    private Context mContext;
    private Display display;

    public ShareDialog(Context context) {
        mContext = context;
        //获取屏幕对象
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    //设置QQ分享
    public ShareDialog setOnQQShare(DialogInterface.OnClickListener qqShareListener) {
        mQQShareListener = qqShareListener;
        return this;
    }

    //设置微信分享
    public ShareDialog setOnWeChatShare(DialogInterface.OnClickListener weChatShareListener) {
        mOnWeChatShareListener = weChatShareListener;
        return this;
    }

    //设置微博分享
    public ShareDialog setOnWeiBoShare(DialogInterface.OnClickListener weiBoShareListener) {
        mWeiBoShareListener = weiBoShareListener;
        return this;
    }

    //设置空间分享
    public ShareDialog setOnQzoneShare(DialogInterface.OnClickListener qzoneShareListener) {
        mQzoneShareListener = qzoneShareListener;
        return this;
    }

    //设置分享朋友圈
    public ShareDialog setOnWeChatFriendShare(DialogInterface.OnClickListener weChatFriendShareListener) {
        mOnWeChatFriendShareListener = weChatFriendShareListener;
        return this;
    }

    //设置复制链接
    public ShareDialog setOnCopyLineShare(DialogInterface.OnClickListener copyLineShareListener) {
        mcopylineShareListener = copyLineShareListener;
        return this;
    }

    //取消分享
    public ShareDialog setOnCancleListener(DialogInterface.OnClickListener cancleListener) {
        mOnCancleListener = cancleListener;
        return this;
    }

    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }

    }

    public void dismiss() {
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }

    /**
     * 创建BaseDialog实例
     *
     * @return
     */


    public ShareDialog builder() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.share_dialg_style, null);
        //设置弹出框横向铺满整个屏幕
        view.setMinimumWidth(display.getWidth());
        mDialog = new Dialog(mContext, R.style.ActionSheetDialogStyle);
        //设置dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
        mDialog.setCanceledOnTouchOutside(true);
        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);
        //设置点击隐藏
        txtCancle = (TextView) view.findViewById(R.id.txtCancel);
        txtCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnCancleListener != null) {
                    mOnCancleListener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);

                }
                dismiss();

            }

        });
        //qq分享
        mQQShare = (LinearLayout) view.findViewById(R.id.mQQShare);
        mQQShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQQShareListener != null) {
                    mQQShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        //微信分享
        mWeChatShare = (LinearLayout) view.findViewById(R.id.mWeChatShare);
        mWeChatShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnWeChatShareListener != null) {
                    mOnWeChatShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        //微博分享
        mWeiBoShare = (LinearLayout) view.findViewById(R.id.mWeiBoShare);
        mWeiBoShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWeiBoShareListener != null) {
                    mWeiBoShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        //空间分享
        mQzoneShare = (LinearLayout) view.findViewById(R.id.mQzoneShare);
        mQzoneShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQzoneShareListener != null) {
                    mQzoneShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        //朋友圈分享
        mWeChatFriendShare = (LinearLayout) view.findViewById(R.id.mWeChatFriendShare);
        mWeChatFriendShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnWeChatFriendShareListener != null) {
                    mOnWeChatFriendShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        //复制链接
        mcopylineShare = (LinearLayout) view.findViewById(R.id.mcopylineShare);
        mcopylineShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcopylineShareListener != null) {
                    mcopylineShareListener.onClick(mDialog, Dialog.BUTTON_POSITIVE);

                }
                dismiss();

            }

        });
        mDialog.setContentView(view);
        return this;

    }

}