package com.collectionStudy.lecture.app.firstclasscollection.sample3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayType {
    NAVER_PAY,
    KAKAO_PAY,
    TOSS,
    PAYCO;

    public static boolean isNaverPay (PayType target) {
        return NAVER_PAY.equals(target);
    }

    public static boolean isKakaoPay(PayType target) {
        return NAVER_PAY.equals(target);
    }

    public static boolean isTossPay(PayType target) {
        return TOSS.equals(target);
    }
}
