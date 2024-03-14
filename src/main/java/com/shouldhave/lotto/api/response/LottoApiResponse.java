package com.shouldhave.lotto.api.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LottoApiResponse {
  private Integer drwNo;
  private String drwNoDate;
  private Integer drwtNo1;
  private Integer drwtNo2;
  private Integer drwtNo3;
  private Integer drwtNo4;
  private Integer drwtNo5;
  private Integer drwtNo6;
  private Integer bnusNo;
  private String returnValue;
  private Long firstAccumamnt;
  private Long firstPrzwnerCo;
  private Long firstWinamnt;
  private Long totSellamnt;
}
