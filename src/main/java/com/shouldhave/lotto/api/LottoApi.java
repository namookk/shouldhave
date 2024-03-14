package com.shouldhave.lotto.api;

import static org.springframework.http.MediaType.TEXT_HTML;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shouldhave.lotto.api.response.LottoApiResponse;
import java.time.Duration;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class LottoApi {

  @Qualifier("lottoWebClient")
  private final WebClient webClient;

  public Mono<LottoApiResponse> getLottoByRound(Integer round) {
    return Mono.just(round)
        .flatMap(this::getLotto);
  }

  public Flux<LottoApiResponse> getLottos() {
    return Flux.range(1, 10)
        .delayElements(Duration.ofSeconds(1))
        .flatMap(this::getLotto)
        .sort(Comparator.comparingInt(LottoApiResponse::getDrwNo))
        .log();
  }

  private Mono<LottoApiResponse> getLotto(Integer round) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/common.do")
            .queryParam("method", "getLottoNumber")
            .queryParam("drwNo", round)
            .build())
        .retrieve()
        .bodyToMono(LottoApiResponse.class)
        .doOnError(e -> log.error(e.getMessage()));
  }
}
