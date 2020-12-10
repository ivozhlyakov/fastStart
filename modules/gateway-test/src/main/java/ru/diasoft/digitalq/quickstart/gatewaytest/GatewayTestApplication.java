package ru.diasoft.digitalq.quickstart.gatewaytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GatewayTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayTestApplication.class, args);
	}

/*    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }

    @Bean
    public RouteLocator createRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/v1/sms-verification/**")
                        .uri("http://localhost:7081/sms-verification")
                        .id("sms-verification")
                )
                .build();
    }
*/

}
