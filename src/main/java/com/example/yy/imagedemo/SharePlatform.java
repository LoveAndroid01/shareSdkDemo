package com.example.yy.imagedemo;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

public class SharePlatform extends Activity implements PlatformActionListener {

    private Context context;

    public SharePlatform(Context context) {
        this.context = context;
        MobSDK.init(this.context, ShareConfig.Appkey, ShareConfig.AppSecret);
    }

    /**
     * 取消分享
     */
    @Override
    public void onCancel(Platform arg0, int arg1) {
        LogUtils.d("onCancel");
        //回调的地方是子线程，进行UI操作要用handle处理
        handler.sendEmptyMessage(6);
    }

    /**
     * 分享完成
     *
     * @param arg0
     * @param arg1
     * @param arg2
     */
    @Override
    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
        LogUtils.d("onComplete");
        //回调的地方是子线程，进行UI操作要用handle处理
        if (arg0.getName().equals(Wechat.NAME)) {//微信
            handler.sendEmptyMessage(1);
        } else if (arg0.getName().equals(WechatMoments.NAME)) {//朋友圈
            handler.sendEmptyMessage(2);
        } else if (arg0.getName().equals(SinaWeibo.NAME)) {//新浪微博
            handler.sendEmptyMessage(3);
        } else if (arg0.getName().equals(QQ.NAME)) {//qq
            handler.sendEmptyMessage(4);
        } else if (arg0.getName().equals(QZone.NAME)) {//qq空间
            handler.sendEmptyMessage(5);
        }
    }

    @Override
    public void onError(Platform arg0, int arg1, Throwable arg2) {
        LogUtils.d("onError", arg2.getMessage());
        //回调的地方是子线程，进行UI操作要用handle处理
        arg2.printStackTrace();
        Message msg = new Message();
        msg.what = 7;
        msg.obj = arg2.getMessage();
        handler.sendMessage(msg);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ToastUtils.show(context, "微信分享成功");
                    break;
                case 2:
                    ToastUtils.show(context, "朋友圈分享成功");
                    break;
                case 3:
                    ToastUtils.show(context, "新浪微博分享成功");
                    break;
                case 4:
                    ToastUtils.show(context, "QQ分享成功");
                    break;
                case 5:
                    ToastUtils.show(context, "QQ空间分享成功");
                    break;
                case 6:
                    ToastUtils.show(context, "分享失败");
                    break;
                case 7:
                    ToastUtils.show(context, "分享失败");
                    break;
                default:
                    break;
            }
        }
    };


    /**
     * 进行分享
     *
     * @param shareType
     * @param shareTitle
     * @param shareText
     * @param shareImageUrl
     * @param shareUrl
     */
    public void share(String shareType, String shareTitle, String shareText, String shareImageUrl, String shareUrl) {
        Platform.ShareParams sharePlatform = new Platform.ShareParams();
        Platform platform;
        /**
         * 如果是微信朋友圈分享
         */
        if (shareType.equalsIgnoreCase(ShareConfig.WeChatMomentsShare)) {
            LogUtils.d("微信朋友圈分享");
            sharePlatform.setShareType(Platform.SHARE_WEBPAGE);

            setSharePlatform(sharePlatform, shareTitle, shareText, shareImageUrl);

            if (shareUrl != null && !shareUrl.equalsIgnoreCase("")) {
                sharePlatform.setUrl(shareUrl);
                LogUtils.d("微信朋友圈分享shareUrl" + shareUrl);
            }
            platform = ShareSDK.getPlatform(WechatMoments.NAME);
            platform.setPlatformActionListener(this);
            platform.share(sharePlatform);
        }
        /**
         * 如果是微信分享
         */
        else if (shareType.equalsIgnoreCase(ShareConfig.WeChatShare)) {
            sharePlatform.setShareType(Platform.SHARE_WEBPAGE);
            LogUtils.d("微信分享");
            setSharePlatform(sharePlatform, shareTitle, shareText, shareImageUrl);
            if (shareUrl != null && !shareUrl.equalsIgnoreCase("")) {
                sharePlatform.setUrl(shareUrl);
                LogUtils.d("微信分享shareUrl" + shareUrl);
            }
            platform = ShareSDK.getPlatform(Wechat.NAME);
            platform.setPlatformActionListener(this);
            platform.share(sharePlatform);
        }
        /**
         * 新浪微博
         */
        else if (shareType.equalsIgnoreCase(ShareConfig.WeiBoShare)) {
            sharePlatform.setShareType(Platform.SHARE_WEBPAGE);
            LogUtils.d("新浪微博分享");
            setSharePlatform(sharePlatform, shareTitle, shareText, shareImageUrl);
            if (shareUrl != null && !shareUrl.equalsIgnoreCase("")) {
                sharePlatform.setUrl(shareUrl);
                LogUtils.d("新浪微博shareUrl" + shareUrl);
            }
            platform = ShareSDK.getPlatform(SinaWeibo.NAME);
            platform.setPlatformActionListener(this);
            platform.share(sharePlatform);
        }
        /**
         *QQ分享
         */
        else if (shareType.equalsIgnoreCase(ShareConfig.QQShare)) {
            sharePlatform.setShareType(Platform.SHARE_WEBPAGE);
            LogUtils.d("QQ分享");
            setSharePlatform(sharePlatform, shareTitle, shareText, shareImageUrl);
            if (shareUrl != null && !shareUrl.equalsIgnoreCase("")) {
                sharePlatform.setUrl(shareUrl);
                LogUtils.d("QQ分享shareUrl" + shareUrl);
            }
            platform = ShareSDK.getPlatform(QQ.NAME);
            platform.setPlatformActionListener(this);
            platform.share(sharePlatform);
        }
        /**
         *QQ空间分享
         */
        else if (shareType.equalsIgnoreCase(ShareConfig.QzoneShare)) {
            sharePlatform.setShareType(Platform.SHARE_WEBPAGE);
            LogUtils.d("QQ空间分享");
            setSharePlatform(sharePlatform, shareTitle, shareText, shareImageUrl);
            if (shareUrl != null && !shareUrl.equalsIgnoreCase("")) {
                sharePlatform.setUrl(shareUrl);
                LogUtils.d("QQ空间分享" + shareUrl);
            }
            platform = ShareSDK.getPlatform(QZone.NAME);
            platform.setPlatformActionListener(this);
            platform.share(sharePlatform);
        }
    }

    /**
     * 分享属性设置
     *
     * @param sharePlatform
     * @param shareTitle
     * @param shareText     描述
     * @param shareImageUrl
     */
    private void setSharePlatform(Platform.ShareParams sharePlatform, String shareTitle, String shareText, String shareImageUrl) {
        sharePlatform.setTitle(shareTitle);
        if (shareText != null && !shareText.equalsIgnoreCase("")) {
            sharePlatform.setText(shareText);
        }
        if (shareImageUrl != null && !shareImageUrl.equalsIgnoreCase("")) {
            sharePlatform.setImageUrl(shareImageUrl);//网络图片
//            sharePlatform.setImagePath(shareImageUrl);//分享本地图片
            LogUtils.d("shareImageUrl:" + shareImageUrl);
        }
    }

    //复制链接
    public void copyLine(Context context) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(ShareConfig.shareUrl);
        String result = cmb.getText().toString();
        if (result.equals(ShareConfig.shareUrl)) {
            ToastUtils.show(context, "复制链接成功");
        }
    }
}