package com.ifi.servlet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface RequestMapping {
    // uri to listen
    String uri();
}
