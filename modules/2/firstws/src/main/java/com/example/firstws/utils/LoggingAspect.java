package com.example.firstws.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@Aspect
public class LoggingAspect {
        private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before("@annotation(LoggerExecute)")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature()
                .getName();

        logger.log(Level.INFO,"---------------------------------------");
        logger.log(Level.INFO, "metod call: " + methodName);
    }

        @AfterReturning(value = "@annotation(LoggerExecute)",returning = "result")
        public void logAfterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {

            logger.log(Level.INFO, "input: {" + paramsToStr(joinPoint)+"}");
            logger.log(Level.INFO, "output: "+objectMapper.writeValueAsString(result));
        }

        @Around("@annotation(LoggerExecute)")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();

            Object proceed = joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - start;

            logger.log(Level.INFO, "executing time " + executionTime + "ms");
            return proceed;
        }

        private String paramsToStr(JoinPoint point) {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            Method method = methodSignature.getMethod();
            Parameter[] parameters = method.getParameters();
            Object[] args = point.getArgs();
            StringBuilder builder = new StringBuilder();
            int i = 0;
            for (Parameter parameter : parameters) {
                if (i > 0) builder.append(", ");
                builder.append(parameter.getName())
                        .append(": ")
                        .append(args[i]);
                ++i;
            }
            return builder.toString();
        }
}
