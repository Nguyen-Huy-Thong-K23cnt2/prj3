package com.nht.day2.ioc_spring;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "<h2> [Spring Boot] Xin chào, " + name + "</h2>" +
                "<h4 style='color:red; text-align:center'>Xin chào!</h4>";
    }
}
