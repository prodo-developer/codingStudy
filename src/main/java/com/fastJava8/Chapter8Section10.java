package com.fastJava8;

import com.fastJava8.model.User;
import com.fastJava8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Parallel Stream 활용한 예제
 */
public class Chapter8Section10 {

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
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@fastcampus.co.kr");
        User user5 = new User()
                .setId(105)
                .setName("Eve")
                .setVerified(false)
                .setEmailAddress("eve@fastcampus.co.kr");
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setVerified(false)
                .setEmailAddress("frank@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

//        long startTime1 = System.currentTimeMillis();
//        EmailService emailService1 = new EmailService();
//        users.stream()
//                .filter(user -> !user.isVerified())
//                .forEach(emailService1::sendVerifyYourEmailEmail);
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("Sequential: " + (endTime1 - startTime1)+"ms");

        long startTime2 = System.currentTimeMillis();
        EmailService emailService2 = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified()).parallel()
                .forEach(emailService2::sendVerifyYourEmailEmail);
        long endTime2 = System.currentTimeMillis();

        System.out.println("Sequential: " + (endTime2 - startTime2)+"ms");

        List<User> processedUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase(Locale.ROOT));
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerifed' to true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());

        System.out.println(processedUsers);
    }
}