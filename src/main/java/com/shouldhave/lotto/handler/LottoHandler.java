package com.shouldhave.lotto.handler;

import com.shouldhave.lotto.payload.dto.LottoDto;
import com.shouldhave.lotto.service.LottoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LottoHandler {

  private final LottoService lottoService;

  public Mono<ServerResponse> findLottos(ServerRequest request) {
    return ServerResponse.ok().body(lottoService.findAll(), LottoDto.class);
  }

  public Mono<ServerResponse> findByRound(ServerRequest request) {
    Integer round = Integer.parseInt(request.pathVariable("round"));
    return ServerResponse.ok().body(lottoService.findLottoById(round), LottoDto.class);
  }

  public Mono<ServerResponse> findWinning(ServerRequest request) {
    return null;
  }
}
