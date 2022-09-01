package com.example.log.aop;


import com.example.log.annotation.LoggerAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect             //@Aspect是将该类声明为切面类
@Component          //@component把该类实例化放入到spring容器中，
public class WebLogAspect {

    //@Pointcut：在使用其他注解时，需要写包的表达式，而@Pointcut就是用来声明一样的包路径
    @Pointcut("@annotation(com.example.log.annotation.LoggerAnnotation)")
    public void LoggerAnnotationCut(){}

    @Around(value = "LoggerAnnotationCut()")  ///先进@Around 再进@Before 再进@After
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuffer sign = new StringBuffer("详情：");

        //把参数拼接到详情里。
        //instanceof String 是判断 是不是string，反正是要字符串类型的 拼接到详情里。
        //这个拼接完的最后效果 好像有点问题，实际用的时候记得看要不要调整。。
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            if (joinPoint.getArgs()[i] instanceof String) {
                sign = sign.append(joinPoint.getArgs()[i] + "; \n");
            } else {
                sign = sign.append(String.valueOf(joinPoint.getArgs()[i]) + "; \n");
            }
        }
        System.out.println("开始打印详情");
        System.out.println(sign.toString());
        System.out.println("结束打印详情");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); //获取methodSignature方法签名
        LoggerAnnotation annotation = methodSignature.getMethod().getAnnotation(LoggerAnnotation.class); //从methodSignature方法签名 获取方法，再获取方法上的注解

        Object proceed = null;
        if (annotation != null) {
            proceed = joinPoint.proceed();
            System.out.println("这里把详情塞到Log实体类中,然后把Log实体类存到数据库里。");
        }
        return proceed;
    }
}
