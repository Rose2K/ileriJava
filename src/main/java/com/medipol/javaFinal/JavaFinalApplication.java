package com.medipol.javaFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class JavaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFinalApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
						.allowedHeaders("*")
						.exposedHeaders(HttpHeaders.CACHE_CONTROL)
						.exposedHeaders(HttpHeaders.CONTENT_LENGTH)
						.exposedHeaders(HttpHeaders.CONTENT_TYPE)
						.exposedHeaders(HttpHeaders.EXPIRES)
						.exposedHeaders(HttpHeaders.PRAGMA)
						.exposedHeaders(HttpHeaders.LOCATION);
			}
		};
	}
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setMaxPayloadLength(10000);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setAfterMessagePrefix("REQUEST DATA: ");
		return loggingFilter;
	}
}
