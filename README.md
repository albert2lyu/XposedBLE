
# XposedBLE 

> 开发助手

# 开发背景

进行BLE开发时，总要经过漫长的调试过程，这个过程和对接http接口挺像的，但是调试http接口时，如果发现接口问题可以通过http抓包工具来很快定位问题，蓝牙开发就没那么轻松了，虽然 [android手机可以通过启用蓝牙HCI信息收集日志](https://blog.csdn.net/wangbf_java/article/details/81269149) ，但是这个日志对于app开发者来说基本上没啥用，因为app开发者只用关心我通过那个UUID发送了那些数据，设备返回了什么，当然通过在代码里写log日志这些信息是可以获得的，也就是每个项目都写一遍同样的日志，除此之外，如果你不想改动代码就想知道蓝牙的通信过程，就没法实现了，经历了以上问题之后，XposedBLE就有它存在的价值了。

XposedBLE 是一个可以抓取蓝牙BLE通信过程的插件，可以显示通过那些UUID发送了那些数据。


# 效果演示
抓取某手环的通信数据

![演示](https://img-blog.csdnimg.cn/20181230035351621.png?x-oss-proess=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmdiZl9qYXZh,size_16,color_FFFFFF,t_70)
# 使用方法
1.在安装Xposed模块root手机安装插件或者使用VirtualXposed 安装插件 [VirtualXposed下载](https://github.com/android-hacker/VirtualXposed/releases)

2.APP和蓝牙设备进行交互过程中，数据包会在logcat(android studio)中显示

# 相关文档
实现原理可以看我的博文 
[使用xposed框架实现蓝牙BLE抓包](https://blog.csdn.net/wangbf_java/article/details/85350130)
