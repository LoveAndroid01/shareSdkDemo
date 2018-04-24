package com.example.yy.imagedemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ShareDialog shareDialog;
    private SharePlatform sharePlatform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button iv_hand = (Button) findViewById(R.id.iv_hand);
        shareDialog = new ShareDialog(this).builder();
        sharePlatform = new SharePlatform(this);
        iv_hand.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_hand:
                //QQ分享
                shareDialog.setOnQQShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharePlatform.share(ShareConfig.QQShare, ShareConfig.shareTitle, ShareConfig.shareDesc, ShareConfig.imagePath, ShareConfig.shareUrl);
                        shareDialog.dismiss();
                    }
                });

                //微信
                shareDialog.setOnWeChatShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharePlatform.share(ShareConfig.WeChatShare, ShareConfig.shareTitle, ShareConfig.shareDesc, ShareConfig.imagePath, ShareConfig.shareUrl);
                        shareDialog.dismiss();
                    }
                });
                //新浪微博
                shareDialog.setOnWeiBoShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharePlatform.share(ShareConfig.WeiBoShare, ShareConfig.shareTitle, ShareConfig.shareDesc, ShareConfig.imagePath, ShareConfig.shareUrl);
                        shareDialog.dismiss();
                    }
                });
                //QQ空间
                shareDialog.setOnQzoneShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharePlatform.share(ShareConfig.QzoneShare, ShareConfig.shareTitle, ShareConfig.shareDesc, ShareConfig.imagePath, ShareConfig.shareUrl);
                        shareDialog.dismiss();
                    }
                });
                //微信朋友圈
                shareDialog.setOnWeChatFriendShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharePlatform.share(ShareConfig.WeChatMomentsShare, ShareConfig.shareTitle, ShareConfig.shareDesc, ShareConfig.imagePath, ShareConfig.shareUrl);
                        shareDialog.dismiss();
                    }
                });
                //复制链接
                shareDialog.setOnCopyLineShare(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharePlatform.copyLine(MainActivity.this);
                        shareDialog.dismiss();
                    }
                });
                //取消分享
                shareDialog.setOnCancleListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        shareDialog.dismiss();
                    }
                });
                shareDialog.show();
                break;
        }
    }
}
