package com.collectionStudy.lecture.app.firstclasscollection.sample3;

import java.util.List;
import java.util.function.Predicate;

import static com.collectionStudy.lecture.app.firstclasscollection.sample3.PayType.*;

public class PayGroups {
    private List<Pay> pays;

    public PayGroups(List<Pay> pays) {
        this.pays = pays;
    }

    public Long getNaverPaySum() {
        return getFilteredPays(pay -> isNaverPay(pay.getPayType()));
    }

    public Long getKakaoPaySum() {
        return getFilteredPays(pay -> isKakaoPay(pay.getPayType()));
    }

    public Long getTossPaySum() {
        return getFilteredPays(pay -> isTossPay(pay.getPayType()));
    }

    private Long getFilteredPays(Predicate<Pay> predicate) {
        return pays.stream()
                .filter(predicate)
                .mapToLong(Pay::getAmount)
                .sum();
    }
}
