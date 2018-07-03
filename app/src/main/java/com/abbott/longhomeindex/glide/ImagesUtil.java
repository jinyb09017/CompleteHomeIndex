package com.abbott.longhomeindex.glide;

import android.widget.ImageView;

import com.abbott.longhomeindex.R;
import com.abbott.longhomeindex.utils.ACallBack;
import com.abbott.longhomeindex.utils.AppContextUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


/**
 * Created by yhl on 16-5-18.
 */
public class ImagesUtil {
    public static void loadImage(String url, ImageView iv) {
        Glide.with(AppContextUtil.getAppContext())
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.default_image)
                .error(R.drawable.default_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv);
    }


    //加载圆角图片
    //加载圆角图片
    public static void loadRoundImage(String url, final ImageView imageView, int defaultImg) {
        Glide.with(AppContextUtil.getAppContext())
                .load(url)
                .placeholder(defaultImg)
                .error(defaultImg)
                //.centerCrop() 千万不要加，加了就没有圆角效果了
                .transform(new CenterCrop(AppContextUtil.getAppContext()), new GlideRoundTransform(AppContextUtil.getAppContext(), 2))
                //https://github.com/bumptech/glide/issues/1026 解决圆角第二次出来的问题
                .dontAnimate()
                .into(imageView);
    }

    public static void loadCircleImage(String url, final ImageView imageView, int defaultImg) {
        Glide.with(AppContextUtil.getAppContext())
                .load(url)
                .placeholder(defaultImg)
                .error(defaultImg)
                //.centerCrop() 千万不要加，加了就没有圆角效果了
                .transform(new GlideCircleTransform(AppContextUtil.getAppContext()))
                //https://github.com/bumptech/glide/issues/1026 解决圆角第二次出来的问题
                .dontAnimate()
                .into(imageView);
    }

    public static void loadRoundImage(String url, final ImageView imageView) {
        loadRoundImage(url, imageView, R.drawable.default_image);
    }


    public static void loadImage(String url, ImageView iv, int defaultImg) {
        Glide.with(AppContextUtil.getAppContext())
                .load(url)
                .asBitmap()
                .placeholder(defaultImg)
                .error(defaultImg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv);
    }

    public static void loadImage(String url, ImageView iv, final ACallBack aCallBack) {
        Glide.with(AppContextUtil.getAppContext())
                .load(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target,
                                               boolean isFirstResource) {


                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (aCallBack != null) {
                            aCallBack.onSuccess();
                        }

                        return false;
                    }
                })
                .into(iv);
    }
}
