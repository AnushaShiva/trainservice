package com.example.trainservice;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class TrainserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrainserviceApplication.class, args);
	}

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("RailWay TRAINSERVICE").apiInfo(apiInfo()).select()
				.paths(regex("/traindetails.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Train-Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our RailWay TRAIN SERVICE Rest API")
				.termsOfServiceUrl("www.anu.com")
				.license("anusha")
				.licenseUrl("www.anu.com").version("1.0").build();
	}

}