package com.shouldhave.lotto.api;

import static org.springframework.http.MediaType.TEXT_HTML;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiConfig {

  @Bean(name = "lottoWebClient")
  public WebClient lottoWebClient() {
    return WebClient.builder()
        .baseUrl("https://www.dhlottery.co.kr")
        .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
        .build();
  }

  private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
    clientCodecConfigurer.customCodecs().encoder(new Jackson2JsonEncoder(new ObjectMapper(), TEXT_HTML));
    clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder(new ObjectMapper(), TEXT_HTML));
  }
}
