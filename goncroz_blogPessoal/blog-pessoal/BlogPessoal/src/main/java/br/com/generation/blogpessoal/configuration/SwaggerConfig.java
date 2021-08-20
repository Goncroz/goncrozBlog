package br.com.generation.blogpessoal.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.generation.blogpessoal.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessageForGET());
	}

	public static ApiInfo metadata() {
		return new ApiInfoBuilder().title("API - Goncroz ").description("API Blog Pessoal - Goncroz")
				.version("1.0.0").license("Apache License Version 2.0").licenseUrl("http://localhost:8080/swagger-ui/")
				.contact(contact()).build();
	}

	private static Contact contact() {
		return new Contact("Lucas Queiroz", "https://github.com/Goncroz",
				"queiroz.goncalveslucas@gmail.com");
	}

	private static List<Response> responseMessageForGET() {
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucess!").build());
				add(new ResponseBuilder().code("201").description("Created!").build());
				add(new ResponseBuilder().code("401").description("Unauthorized!").build());
				add(new ResponseBuilder().code("403").description("Forbidden!").build());
				add(new ResponseBuilder().code("404").description("Not Found!").build());
				add(new ResponseBuilder().code("500").description("404").build());
			}
		};
	}

}
