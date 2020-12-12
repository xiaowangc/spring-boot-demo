交互设计：

系统设计：

传统接口设计：
    url请求           操作            参数传递                   操作结果
1)/guest/list       查询列表        无参数传递                返回结果：List<Guest>
2)/guest/toAdd      点击增加按钮    返回add.html页面          需填写名字和角色
3/guest/add         增加操作        传参Guest对象             返回结果：跳转到list页面
4)/guest/toUpdate   点击编辑按钮    传参guest.name            跳转到update.html页面 名字固定 角色可改
5)/guest/update     修改操作        传参Guest                 跳转到list页面
6)/guest/delete     点击删除按钮    传参guest.name            后端进行删除操作后跳转到list页面


RESTFul风格接口设计：
    url请求               HTTP method       操作           参数传递             操作结果
1) /guest                  GET           查询列表           无                返回 List<Guest>
2) /guest/toAdd            GET          点击增加按钮         无               跳转到add.html页面
3) /guest                  POST          增加操作        传递Guest对象        跳转到 /guest
4) /guest/toUpdate/{name}  GET          点击修改按钮       传递{name}         跳转到 update.html
5) /guest                  PUT           修改后提交      传递Guest对象        修改后跳转到 /guest
6) /guest/{name}          DELETE     点击删除按钮，表单下操作  传递{name}     删除操作后跳转到 /guest

注意：
form表单原生只支持post/get 的请求方式，需要使用的隐藏类型的input标签实现put 或 delete的提交方式