package com.example.log.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)            //意思是下面LoggerTestAnnotation这个注解 只能作用在方法上
@Retention(RetentionPolicy.RUNTIME)    //定义被它所注解的注解保留多久。RUNTIME是在程序运行期间，将一直保留
@Documented                            //@Document 是 java 在生成文档，是否显示注解的开关。
public @interface LoggerAnnotation {
    Logger modelName();

    enum Logger {
        //客户资料模块
        update_cus_model("客资模块", "修改客资"),

        //员工
        update_emp("员工模块", "修改员工信息"),

        //支出
        update_spend("支出模块", "修改"),
        ;

        private String modelName;
        private String methodName;

        public String getModelName() {
            return modelName;
        }

        public String getMethodName() {
            return methodName;
        }

        Logger(String modelName, String methodName) {
            this.modelName = modelName;
            this.methodName = methodName;
        }
    }
}
