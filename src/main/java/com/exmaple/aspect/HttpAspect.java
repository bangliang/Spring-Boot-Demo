package com.exmaple.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    //  使用org自带的框架实现输出，底层实现是logback
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    在所有controller执行之前进行拦截
//    @Before("execution(public * com.exmaple.controller.DemoController.*(..))")
//    public void log(){
//        System.out.println(111);
//    }

//    @After("execution(public * com.exmaple.controller.DemoController.*(..))")
//    public void after(){
//        System.out.println(222);
//    }

//    可以用另外一种方法，防止重复代码
    @Pointcut("execution(public * com.exmaple.controller.DemoController.*(..))")
    // 定义一个通用的方法
    public void log(){
    }

    // 获取http请求的内容
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        System.out.println(111);
//        logger.info("111");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName()); // 获取类名+类方法

        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
//        System.out.println(222);
        logger.info("222");
    }

    // 获取请求返回的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
//        logger.info("response={}", object.toString());

    }
}
