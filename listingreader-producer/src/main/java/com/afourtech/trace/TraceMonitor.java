package com.afourtech.trace;


import com.afourtech.standart.logger.LoggerThreadLocal;
import com.afourtech.standart.logger.Method;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TraceMonitor {

    @Pointcut(value = "execution(* com.afourtech.controller.resources.CategoryService.*(..))")
    private void executionInService() {
        //do nothing, just for pointcut def
        System.out.println("Inside PointCut=====");
    }

    @Before(value = "executionInService()")
    public void pushStackInBean(JoinPoint joinPoint) {
        pushStack(joinPoint);
    }

    @AfterReturning(value = "executionInService()", returning = "returnValue")
    public void popStackInBean(Object returnValue) {
        popStack(returnValue);
    }

    ObjectMapper mapper = new ObjectMapper();

    private void pushStack(JoinPoint joinPoint) {
            Method m = new Method();
            m.setMethodName(StringUtils.replace(joinPoint.getSignature().toString(), "com.afourtech.controller.", ""));
            String input = getInputParametersString(joinPoint.getArgs());
            m.setInput(input);
            m.setTimeInMs(Long.valueOf(System.currentTimeMillis()));
            LoggerThreadLocal.getMethodStack().push(m);
    }

    private String getInputParametersString(Object[] joinPointArgs) {
        String input;
        try {
            input = mapper.writeValueAsString(joinPointArgs);
        } catch (Exception e) {
            input = "Unable to create input parameters string. Error:" + e.getMessage();
        }
        return input;
    }


    private void popStack(Object output) {
        Method childMethod = LoggerThreadLocal.getMethodStack().pop();
        try {
            childMethod.setOutput(output==null?"": mapper.writeValueAsString(output));
        } catch (JsonProcessingException e) {
            childMethod.setOutput(e.getMessage());
        }
        childMethod.setTimeInMs(Long.valueOf(System.currentTimeMillis() - childMethod.getTimeInMs().longValue()));
        if (LoggerThreadLocal.getMethodStack().isEmpty()) {
            LoggerThreadLocal.setMainMethod(childMethod);
        } else {
            Method parentMethod = LoggerThreadLocal.getMethodStack().peek();
            addChildMethod(childMethod, parentMethod);
        }
    }

    private void addChildMethod(Method childMethod, Method parentMethod) {
        if (parentMethod != null) {
            if (parentMethod.getMethodList() == null) {
                parentMethod.setMethodList(new ArrayList<>());
            }
            parentMethod.getMethodList().add(childMethod);
        }
    }

    public void printTrace() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("\n<TRACE>\n").append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(LoggerThreadLocal.getMainMethod()));
            sb.append("\n</TRACE>");
            System.out.println(sb.toString());
        } catch (JsonProcessingException e) {
            StringUtils.abbreviate(ExceptionUtils.getStackTrace(e), 2000);

        }
    }
}