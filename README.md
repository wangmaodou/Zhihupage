# Zhihupage
Start Page for Zhihu Android APP.

The key code is adding a application window while the APP is starting through 

     getWindowManager().addView();
     
and remove the window through a Handler
     
     getWindowManager().removeView();
     new Handler().postDelayed();
     
 ![](./gif/zhihupage.gif)
