package com.shouldhave.lotto.payload.dto;

import com.shouldhave.lotto.api.response.LottoApiResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LottoDto {
  private Integer round;
  private LocalDate lottoDate;
  private List<Integer> winningNums;
  private Integer bonusNum;

  public static LottoDto from(LottoApiResponse response) {
    return LottoDto.builder()
        .round(response.getDrwNo())
        .lottoDate(LocalDate.parse(response.getDrwNoDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        .winningNums(List.of(
            response.getDrwtNo1(),
            response.getDrwtNo2(),
            response.getDrwtNo3(),
            response.getDrwtNo4(),
            response.getDrwtNo5(),
            response.getDrwtNo6()
            ))
        .bonusNum(response.getBnusNo())
        .build();
  }
}
