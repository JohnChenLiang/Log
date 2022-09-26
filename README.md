# Log
运行起来，在浏览器输入下面的网址即可看效果。idea控制台有相应打印效果
http://localhost:1001/log/updateEmp?empName=cl&phone=333

AOP用法记录日志：1.先加个注解文件 然后写上枚举。
                2.再在aop文件下 建个class类文件，加上
                @Aspect @Component 两个注解，然后加一个这个
                @Pointcut("@annotation()")
                  public void LoggerAnnotationCut() {}
                然后@annotation后面的括号 填上 最开始加的注释文件的地址。


                3然后再加上一个这个
                @Around(value = "LoggerAnnotationCut()")
                public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
                    String sign = "详情："; //遍历joinPoint.getArgs() 把参数拼接到详情后面。
                    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                     LoggerAnnotation annotation = methodSignature.getMethod().getAnnotation(LoggerAnnotation.class);
                    Object proceed = null;
                    if (null != annotation) {
                        proceed = joinPoint.proceed();
                        //把日志加到数据库
                    }
                    return proceed;
                }

1.aop实现自定义注解 记录 增改删数据库的操作记录。直接在controller那加注解 不用侵入代码。
