package com.chige.controller;

import com.chige.openfeign.config.FoodConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** thymeleaf 模板有五种常用表达式
 *  表达式一: 变量表达式 ${}
 *              用法：th:text="${}"
 *  表达式二: 选择表达式 *{} 需要先有一个对象引入
 *              用法：先有th:object="${}" 包含 th:text="*{}"
 *  表达式三: 链接url表达式 @{/xxx}
 *              用法：一般在a连接 th:href="@{/xxx}"
 *  表达式四: 消息表达式 #{}
 *              用法: th:text="#{message}"  有一个message.properties文件，内容 message= value值
 *  表达式五: 片段表达式 ~{}
 *              用法： 创建一个模板<footer th:fragment="frag1">yyy</>
 *                    在页面加载模板三种方式: th:insert="footer :: frag1"
 *                                          th:replace="footer :: frag1"
 *                                          th:include="footer :: frag1" 官方3.0不推荐
 */
@Controller
public class ThymeleafController {

    @Autowired
    private FoodConfig foodConfig;


    /** 变量表达式 和 选择表达式 的 demo
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index1(Model model){
        model.addAttribute("name","小胡");
        model.addAttribute("food",foodConfig);

        return "/thymeleaf/index";
    }

    /** 链接url 表达式的 demo
     *  控制层类可直接返回
     *
     * @return
     */
    @RequestMapping("/welcome1")
    public String urlExp(Model model){
        model.addAttribute("from","welcome1");
        return "/thymeleaf/urlExpression";
    }

    @RequestMapping("/welcome")
    public String urlExp2(Model model){
        model.addAttribute("from","welcome");
        return "/thymeleaf/urlExpression";
    }

}
