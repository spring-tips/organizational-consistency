package numbers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableConfigurationProperties(NumberProperties.class)
@ConditionalOnClass(ThreadLocalRandom.class)
public class NumbersAutoconfiguration {

	@Bean
	NumberService numberService(NumberProperties properties) {
		return new NumberService(properties);
	}

	@Configuration
	@ConditionalOnClass(RouterFunction.class)
	public static class WebConfig {

		@Bean
		RouterFunction<ServerResponse> routes(NumberService ns) {
			HandlerFunction<ServerResponse> number = request -> {
				Map<String, Integer> body = singletonMap("number",
						ns.generateRandomNumber());
				return ok().syncBody(body);
			};
			return route() //
					.GET("/number", number) //
					.build();
		}

	}

}
