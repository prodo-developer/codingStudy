package com.fastJava8;

import com.fastJava8.model.Order;
import com.fastJava8.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Chapter6Section4 {

    public static void main(String[] args) {
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        List<Optional<String>> emails = new ArrayList<>();
        for (User user: users) {
            if (!user.isVerified()) {
                Optional<String> email = user.getEmailAddress();
                emails.add(email);
            }
        }
        System.out.println(emails);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(40));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(105)
                .setCreatedAt(now.minusHours(10));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        // TODO: Find orders in Error status, and extract createdByUserIds as a list
        List<Long> orderList = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());

        System.out.println(orderList);

        // TODO: Find orders in ERROR status and created within 24 hours
        List<Order> orderList24 = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());

        System.out.println(orderList24);

        // TODO: Create list of createdByUserId and CreatedByUserId 1,2
        List<Long> idList = orders.stream()
                .map(Order::getCreatedByUserId)
                .filter(x -> x < 103)
                .collect(Collectors.toList());

        System.out.println(idList);

        // etc
        List<Order> totalList = new ArrayList<>();

        for (Order order : orders) {
            if(order.getStatus().equals(Order.OrderStatus.ERROR) && order.getCreatedAt().isAfter(now.minusHours(24))) {
                totalList.add(order);
            }
        }
        System.out.println(totalList);


    }
}