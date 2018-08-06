# ExBaseRecyclerViewAdapterHelper

ExBaseRecyclerViewAdapterHelper是在BRVAH 的基础上改动而来的,
主要改动是将 ViewHolder与layout布局文件进行绑定，
Adapter不需要感知布局文件的存在只需要传入相应的ExBaseViewHolder子类Class并在onBindData方法中实现数据绑定，
在使用时直接new ExBaseAdapter即可。

这样做的好处是ViewHolder可以使用ButterKnife等注入插件实现自动绑定View操作，并且如果View发生变化只需要修改对应的ViewHolder即可，避免了所有的代码都堆积到一个类中，也不再需要创建如ItemProvider等这样的中间类了，开发者只需要关心对应的ViewHolder中的业务逻辑即可。

# Sample:
### Step 1.在Project级的build.gradle 中添加仓库地址
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### step 2.在app目录下的build.gradle中添加依赖
```java
dependencies {
            //ExBaseAdapter
	        implementation 'com.github.wwwtete:ExBaseRecyclerViewAdapterHelper:v1.0.0'
}
```
### Step 3.在代码中自定义ViewHolder
``` java
//Status 是自己指定的泛型,可以是任意类型，但是必须保证指定的泛型与ExBaseAdapter中的数据泛型保持一致或是基类

//注意：继承ExBaseViewHolder的子类必须要有一个接收ViewGroup或View的构造函数，否则会创建失败，
//       如果继承ExBaseViewHolder的子类是内部类，则必须是public static修饰的公共静态内部类。

public class AnimationVH extends ExBaseViewHolder<Status> {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tweetName)
    TextView mTweetName;

    /**
    * 子类必须要有一个接收ViewGroup或View的构造函数，否则会创建失败，重要的事情说三遍。
    * 子类必须要有一个接收ViewGroup或View的构造函数，否则会创建失败，重要的事情说三遍。
    * 子类必须要有一个接收ViewGroup或View的构造函数，否则会创建失败，重要的事情说三遍。
    **/
    public AnimationVH(ViewGroup parent) {
        //R.layout.layout_animation 是自定义的布局文件
        super(parent, R.layout.layout_animation);
        ButterKnife.bind(this,itemView);
    }

    /**
    * 将数据与View进行绑定
    **/
    @Override
    protected void onBindData(Status status) {

        switch (getLayoutPosition() % 3) {
            case 0:
                mImg.setImageResource(R.mipmap.animation_img1);
                break;
            case 1:
                mImg.setImageResource(R.mipmap.animation_img2);
                break;
            case 2:
                mImg.setImageResource(R.mipmap.animation_img3);
                break;
        }
    }
 }
```
### Step 4.在Activity中使用自定义的ViewHolder
``` java
public class AnimationUseActivity extends Activity {
    private void initAdapter() {
           List<Status> list = DataServer.getSampleData(100);
           //将AnimationVH的Class传给ExBaseAdapter即可
           ExBaseAdapter<Status> mAnimationAdapter = new ExBaseAdapter<Status>(AnimationVH.class, list);
           mRecyclerView.setAdapter(mAnimationAdapter);
    }
}
```

详细用法，大家可以参考项目中的Demo或原作者的[博文](https://www.jianshu.com/p/b343fcff51b0)，其中只需要将BaseQuick开头的改成ExBase即可，其他方法都没变化，最后非常感谢[BRVAH](https://github.com/CymChad/BaseRecyclerViewAdapterHelper) 。


# proguard-rules
``` java
-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(...);
}
-keepclassmembers  class **$** extends com.chad.library.adapter.base.ExBaseViewHolder {
     <init>(...);
}
```


