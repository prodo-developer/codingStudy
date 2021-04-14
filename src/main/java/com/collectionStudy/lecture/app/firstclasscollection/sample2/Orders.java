package com.collectionStudy.lecture.app.firstclasscollection.sample2;

import java.util.List;

/**
 * 컬렉션의 값을 변경할 수 있는 메소드가 없는 컬렉션
 * 불변 컬렉션
 *
 * 이 클래스는 생성자와 getAmountSum() 외에 다른 메소드가 없습니다.
 * 즉, 이 클래스의 사용법은 새로 만들거나 값을 가져오는 것뿐인거죠.
 * List라는 컬렉션에 접근할 수 있는 방법이 없기 때문에 값을 변경/추가가 안됩니다.
 */
public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public long getAmountSum() {
        return orders.stream()
                .mapToLong(Order::getAmount)
                .sum();
    }
}
