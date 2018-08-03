package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Status;
import com.chad.baserecyclerviewadapterhelper.util.SpannableStringUtils;
import com.chad.baserecyclerviewadapterhelper.util.ToastUtils;
import com.chad.baserecyclerviewadapterhelper.util.Utils;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class NestVH extends BaseVH<Status> {
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tweetName)
    TextView mTweetName;
    @BindView(R.id.tweetText)
    TextView mTweetText;
    @BindView(R.id.tweetDate)
    TextView mTweetDate;

    public NestVH(ViewGroup parent) {
        super(parent, R.layout.layout_nest_item);
        addOnClickListener(R.id.tweetText);
    }

    @Override
    protected void onBindData(Status status) {

        switch (getLayoutPosition() %
                3) {
            case 0:
                mImg.setImageResource( R.mipmap.animation_img1);
                break;
            case 1:
                mImg.setImageResource( R.mipmap.animation_img2);
                break;
            case 2:
                mImg.setImageResource(R.mipmap.animation_img3);
                break;
        }
        mTweetName.setText("Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        mTweetText.setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        mTweetText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
