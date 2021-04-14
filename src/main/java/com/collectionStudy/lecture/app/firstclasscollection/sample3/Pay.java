package com.collectionStudy.lecture.app.firstclasscollection.sample3;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Pay {

    private PayType payType;
    private long amount;

    @Builder
    public Pay(PayType payType, long amount) {
        this.payType = payType;
        this.amount = amount;
    }

}
