package br.newdevgirls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	private Contact contact() {
		return new Contact("New devGirls",
				"https://github.com/New-devGirls",
				"newdevgirls@email.com");
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("New devGirls")
				.description("API de uma WishList - Squad: New devGirls")
				.version("1.0")
				.contact(contact())
				.build();
	}
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.newdevgirls.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
}
