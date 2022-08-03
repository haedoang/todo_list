package io.haedoang.todolist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${spring.servlet.multipart.location}")
    private String fileUploadPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:///" + fileUploadPath());
    }
    @Bean
    public String fileUploadPath() {
        return fileUploadPath;
    }
}
