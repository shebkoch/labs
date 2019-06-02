package com.shebkoch.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.shebkoch")
public class VmApplication {

    public static void main(String[] args) {
        SpringApplication.run(VmApplication.class, args);
    }
}
