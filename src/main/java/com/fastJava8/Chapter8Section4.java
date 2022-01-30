package com.fastJava8;

import com.fastJava8.model.Order;
import com.fastJava8.model.OrderLine;
import com.fastJava8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 리듀스를 활용한 예제
 */
public class Chapter8Section4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);

        Integer sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(sum);

        Integer min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y).get();

        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x,y) -> x * y);

        System.out.println(product);

        List<String> numberList = Arrays.asList("3", "2", "5", "-4");
        Integer sumNumber = numberList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);

        System.out.println(sumNumber);

        // 추천안하는 방법
        Integer strNum = numberList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);
        System.out.println(strNum);

        // 문제
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user3 = new User()
                .setId(103)
                .setName("Prodo")
                .setFriendUserIds(Arrays.asList(204, 205, 207));

        List<User> users = Arrays.asList(user1, user2, user3);

        // 친구수의 합 구하기
        Integer friendCnt = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size) // 4 3 3
                .reduce(0, (x, y) -> x + y);

        System.out.println(friendCnt);
        
        // Order들의 총합 구하기
        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000))));

        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));

        Order order3 = new Order()
                .setId(1003L)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000))));

        List<Order> orders = Arrays.asList(order1, order2, order3);

        BigDecimal orderSum = orders.stream()
                .map(Order::getOrderLines) // Stream<List<OrderLine>>
                .flatMap(List::stream)// flatMap을 통해 한번더 접근 Stream<OrderLine>
                .map(OrderLine::getAmount) // Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("값 : " + orderSum);
    }
}