package com.unisinsight.swagger.comfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
        //@Bean
        public WebMvcConfigurationSupport addResourceHandlers() {
            return new WebMvcConfigurationSupport() {
                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
                    registry.addResourceHandler("swagger-ui.html")
                            .addResourceLocations("classpath:/META-INF/resources/");
                    registry.addResourceHandler("/webjars/**")
                            .addResourceLocations("classpath:/META-INF/resources/webjars/");
                }

            };
        }

        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.unisinsight.swagger.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }
        //@Bean
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title(" RESTful APIs")
                    .description("后台api接口文档")
                    .version("1.0")
                    .build();
        }

}
