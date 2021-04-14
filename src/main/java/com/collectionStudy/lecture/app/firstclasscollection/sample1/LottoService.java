package com.collectionStudy.lecture.app.firstclasscollection.sample1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 복권 게임
 * 해당 조건
 * 6개의 번호가 존재 (보너스 번호는 제외)
 * 6개의 번호는 서로 중복되지 않아야 함
 *
 * 문제점
 * 1. List<Long> 으로 된 데이터는 모두 검증 로직이 필요할까?
 * 2. 신규 입사자분들은 어떻게 이 검증로직이 필요한지 알 수 있을까?
 * 등등 모든 코드와 도메인을 알고 있지 않다면 언제든 문제가 발생할 여지가 있다.
 *
 */
public class LottoService {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public void createLottoNumber() {
        List<Long> lottoNumbers = createNoDuplicateNumbers();
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        // 이후 로직 실행
    }

    private List<Long> createNoDuplicateNumbers() {
        return new ArrayList<>();
    }

    private void validateDuplicate(List<Long> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateSize(List<Long> lottoNumbers) {
        Set<Long> noDuplicateNumbers = new HashSet<>(lottoNumbers);
        if(noDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }
}
