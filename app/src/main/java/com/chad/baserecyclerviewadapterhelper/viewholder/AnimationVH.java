package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Status;
import com.chad.baserecyclerviewadapterhelper.util.ClickableMovementMethod;
import com.chad.baserecyclerviewadapterhelper.util.SpannableStringUtils;
import com.chad.baserecyclerviewadapterhelper.util.ToastUtils;
import com.chad.baserecyclerviewadapterhelper.util.Utils;
import com.chad.library.adapter.base.ExBaseViewHolder;

;

/**
 * Created by wangw on 2018/8/2.
 */

public class AnimationVH extends ExBaseViewHolder<Status> {

    ImageView mIv;
    TextView mTv;
    public AnimationVH(ViewGroup parent) {
        super(parent, R.layout.layout_animation);
        mIv = itemView.findViewById(R.id.img);
        mTv = itemView.findViewById(R.id.tweetText);
        addOnClickListener(R.id.img);
        addOnClickListener(R.id.tweetName);
    }

    @Override
    protected void onBindData(Status status) {

        switch (getLayoutPosition() %3) {
            case 0:
                setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) getView(R.id.tweetText)).setFocusable(false);
        ((TextView) getView(R.id.tweetText)).setClickable(false);
        ((TextView) getView(R.id.tweetText)).setLongClickable(false);
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
