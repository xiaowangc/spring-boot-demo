package com.chige.resolver;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
//错误页方式三：
// 错误视图解析器 拦截错误状态码 并响应到指定的错误页中去
//优先级： 错误视图解析器 > templates.error > public.error
@Component
public class MyErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if (status.equals(HttpStatus.NOT_FOUND)){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/resolver404");
//            mv.addObject("error404","测试异常");
            return mv;
        }
        return null;
    }
}
