package io.haedoang.todolist.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final String WIN_OS = "Windows";
    @Value("${spring.servlet.multipart.location}")
    private String fileUploadPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String resourceLocation = getResourceLocation(fileUploadPath());
        log.info("resourceLocation : {}", resourceLocation);
        registry.addResourceHandler("/images/**").addResourceLocations(resourceLocation);
    }

    @Bean
    public String fileUploadPath() {
        log.info("fileUploadPath: {}", fileUploadPath);
        return fileUploadPath;
    }

    private String getResourceLocation(String uploadPath) {
        return isWindowOs() ? "file:///" + uploadPath : "file:" + uploadPath;
    }

    private boolean isWindowOs() {
        return System.getProperty("os.name").contains(WIN_OS);
    }
}
