package com.collectionStudy.lecture.app.firstclasscollection.sample1;

import java.util.ArrayList;
import java.util.List;

/**
 * 일급컬렉션 사용 : 해당 조건으로만 생성할 수 있는 자료구조를 만들면 위에서 언급한 문제들이 모두 해결
 * 장점 : 필요한 로직은 모두 LottoTicket에서 사용 가능 하다.
 */
public class LottoService2 {

    public void createLottoNumber() {
       LottoTicket lottoTicket = new LottoTicket(createNoDuplicateNumbers());
    }

    private List<Long> createNoDuplicateNumbers() {
        return new ArrayList<>();
    }
}
