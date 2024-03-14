package com.shouldhave.lotto.service;

import com.shouldhave.lotto.api.LottoApi;
import com.shouldhave.lotto.payload.dto.LottoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LottoService {

  private final LottoApi lottoApi;

  public Flux<LottoDto> findAll() {
    return lottoApi.getLottos()
        .map(LottoDto::from);
  }

  public Mono<LottoDto> findLottoById(Integer round) {
    return lottoApi.getLottoByRound(round)
        .map(LottoDto::from);
  }
}
