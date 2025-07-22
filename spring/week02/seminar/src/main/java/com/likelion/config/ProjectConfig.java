package com.likelion.config;

import com.likelion.bean.Lion;
import com.likelion.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.likelion.proxy","com.likelion.service","com.likelion.repository"})
public class ProjectConfig {
    /* @Bean
    public Lion lion(){
        Lion lion = new Lion();
        lion.setName("babylion");
        return lion;
    }

    @Bean
    public Person person(Lion lion){
        Person p = new Person();
        p.setName("seoah");
        p.setLion(lion);
        return p;
    }
    */

}
