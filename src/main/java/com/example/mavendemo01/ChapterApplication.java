package com.example.mavendemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ImportResource("classpath:xmlpropertoes.xml")//加载自定义xml配置文件位置*/
public class ChapterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class,args);
    }
}
