package zenov.example.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
class SpringCloudGatewaySampleApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	@SuppressWarnings("unchecked")
	public void pathRouteWorks() {
		webClient.get().uri("/get")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Map.class)
				.consumeWith(result -> {
					assertThat(result.getResponseBody()).isNotEmpty();
				});
	}

//	@Test
//	public void contextLoads() throws Exception {
//		webClient
//				.get().uri("/get")
//				.exchange()
//				.expectStatus().isOk()
//				.expectBody()
//				.jsonPath("$.headers.Hello").isEqualTo("World");
//
//		webClient
//				.get().uri("/delay/3")
//				.header("Host", "www.circuitbreaker.com")
//				.exchange()
//				.expectStatus().isOk()
//				.expectBody()
//				.consumeWith(
//						response -> assertThat(response.getResponseBody()).isEqualTo("fallback".getBytes()));
//	}
}
