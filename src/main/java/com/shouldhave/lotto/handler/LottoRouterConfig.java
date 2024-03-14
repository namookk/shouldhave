package com.shouldhave.lotto.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class LottoRouterConfig {

  @Bean
  public RouterFunction<ServerResponse> lottoRouter(LottoHandler lottoHandler) {
    return RouterFunctions.route()
        .GET("/lottos", lottoHandler::findLottos)
        .GET("/lottos/{round}", lottoHandler::findByRound)
        .GET("/lottos/winnings", lottoHandler::findWinning)
        .build();
  }
}
