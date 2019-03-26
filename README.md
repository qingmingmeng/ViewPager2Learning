# ViewPager2Learning
google新推出的ViewPager2，研究学习一下它的特性和用法

1、ViewPager2继承自ViewGroup，与大家熟知的ViewPager可以说没有任何关系，相互不兼容。

2、ViewPager2支持横向与纵向滚动，方便快捷，只需要在xml中或者代码中设置orientation=vertical/horizontal

3、Adapter、API变动：
  
  使用FragmentStateAdapter替换了FragmentStatePagerAdapter
  
  使用RecyclerView.Adapter替换了PagerAdapter
  
  使用registerOnPageChangeCallback替换了addPageChangeListener
  
4、关于预加载，相信ViewPager的预加载机制让不少人头疼过，想禁用而不得法，现在ViewPager2就无需为此苦恼了，经过实测，ViewPager2没有预加载机制

5、setUserVisibleHint(boolean isVisibleToUser)方法在fragment切换过程中不会被执行，但是当我们需要判断fragment是否在前台展示的时候，getUserVisibleHint()方法依然可以使用。

6、跳转到特定fragment页面时可以用：public void setCurrentItem(int item, boolean smoothScroll)，该方法第二个参数设为true时，会有平缓滑动的效果，设为false时，则不会有滑动效果。（注意：假设有三个fragment A,B,C，B位于A与C之间，如果当前正在展示A，通过setCurrentItem方法直接跳到C，如果smoothScroll=true，则必会先执行B的生命周期，然后执行C的生命周期，如果smoothScroll=false，则会直接执行C的生命周期）

7、注意：本例中Fragment的包路径为：androidx.fragment.app.Fragment
