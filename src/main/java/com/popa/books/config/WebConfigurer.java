package com.popa.books.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * We map a server folder to a relative path, accessible from application.
 */
@Component
public class WebConfigurer extends WebMvcConfigurerAdapter {

    private final BooksApplicationProperties props;

    public WebConfigurer(BooksApplicationProperties props) {
        this.props = props;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(props.getUploadsRelativePath() + "**").addResourceLocations("file:" + props.getFullUploadDir());
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

}