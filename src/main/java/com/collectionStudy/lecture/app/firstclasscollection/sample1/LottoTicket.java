package com.collectionStudy.lecture.app.firstclasscollection.sample1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 일급컬렉션 생성
 *
 * 1. 일급 컬렉션은 컬렉션의 불변을 보장합니다.
 * 참고로 java의 final은 정확히 불변을 만들어 주는것은 아니며, 재할당만 금지합니다.
 */
public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Long> lottoNumbers;

    public LottoTicket(List<Long> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Long> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Long> lottoNumbers) {
        Set<Long> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }
}
