package com.nht.day2.ioc;

public class Client {
    private Service service;

    public Client() {
        service = new Service(); // Không dùng IoC
    }

    public void doSomething() {
        service.serve();
    }
}
