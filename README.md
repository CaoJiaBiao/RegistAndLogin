﻿# RegistAndLogin

个人信息注册与登录

架构为常见的JavaWeb三层架构。

注册时用到的技术：
  
  1. Jquery中提供的的Ajax在不刷新页面的情况下验证用户名是否可用，验证过程是Ajax传给Servlet，Servlet查询数据库知否存在该用户名，并反馈给页面。
    
  2. 页面中的验证码由单独的Servlet传递图像的流，在页面中显示，而且有Servlet来验证验证码是否正确。
    
  3. 当用户名、密码和验证码等信息都可用时，这时就要往数据库中存入该用户，为了安全着想，密码的保存形式为其的MD5码。
    
登录时用到的技术：
  
  1. cookie技术（未添加）

  2. Jquery和Servlet
  
部分界面截图如下：

![截图1](https://github.com/CaoJiaBiao/RegistAndLogin/raw/master/Screenshots/1.png)

![截图1](https://github.com/CaoJiaBiao/RegistAndLogin/raw/master/Screenshots/2.png)

![截图1](https://github.com/CaoJiaBiao/RegistAndLogin/raw/master/Screenshots/3.png)

![截图1](https://github.com/CaoJiaBiao/RegistAndLogin/raw/master/Screenshots/4.png)
