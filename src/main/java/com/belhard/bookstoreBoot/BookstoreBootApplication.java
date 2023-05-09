package com.belhard.bookstoreBoot;

import com.belhard.bookstoreBoot.web.filters.Filter;
import com.belhard.bookstoreBoot.web.interceptor.MyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BookstoreBootApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreBootApplication.class, args);
    }

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean<Filter> filter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter());
        registrationBean.addUrlPatterns("/users/getAll", "/users/delete", "/books/create", "/books/update/*", "/books/delete/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
