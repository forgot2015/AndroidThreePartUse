package com.linzongfu.androidthreepartuse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

//        Picasso使用
        Picasso.get()
                .load("http://www.k1982.com/show/up/201304/2013040500250971.jpg")
                .placeholder(R.drawable.ic_home) //设置占位符图片
                .error(R.drawable.ic_home) //设置加载出错时的图片
                .noFade()  //设置没有逐渐出现的动画
                .resize(400, 200)//设置加载图片的尺寸
                .onlyScaleDown()//调用onlyScaleDown 方法，只有当原始图片的尺寸大于我们指定的尺寸时，resize才起作用
                .centerCrop()//充满ImageView 的边界，居中裁剪。
                .centerInside()//上面的centerCrop是可能看不到全部图片的，如果你想让View将图片展示完全，可以用centerInside，但是如果图片尺寸小于View尺寸的话，是不能充满View边界的。
                .fit();
//        fit 是干什的呢？上面我们需要用resize()来指定我们需要的图片的尺寸，那就是说在程序中需要我们计算我们需要的
//        尺寸（固定大小的除外），这样很麻烦，fit 方法就帮我们解决了这个问题。
//        fit 它会自动测量我们的View的大小，然后内部调用reszie方法把图片裁剪到View的大小，
//        这就帮我们做了计算size和调用resize 这2步。非常方便，使用fit 还是会出现拉伸扭曲的情况，因此最好配合前面的
        /*特别注意，
1，fit 只对ImageView 有效
2，使用fit时，ImageView 宽和高不能为wrap_content,很好理解，因为它要测量宽高。
.rotate(180)//在图片显示到ImageView 之前，还可以对图片做一些旋转操作，调用rotate(int degree)方法*/
    }
}
