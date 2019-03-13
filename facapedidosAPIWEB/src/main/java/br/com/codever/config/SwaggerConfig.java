package br.com.codever.config;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.codever"))
				.paths(postPaths())
				.build()
				.apiInfo(metaInfo());
	}

	private Predicate<String> postPaths() {
		// TODO Auto-generated method stub
		return regex("/api.*");
	}

	private ApiInfo metaInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo = new ApiInfo(
				"FaçaPedidos API REST",
				"API REST  de cadastro de produtos e compras",
				"1.0",
				"Terms of Service",
				new Contact("Everton Gonçalves", "https://github.com/dsgeverton" , "dsgeverton@gmail.com"),
				"Apache License Version 2.0",
				"https://codever.com.br/license", new ArrayList<VendorExtension>());
		return apiInfo;
	}
	
}
