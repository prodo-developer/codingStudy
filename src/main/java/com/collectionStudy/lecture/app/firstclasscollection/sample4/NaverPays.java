package com.collectionStudy.lecture.app.firstclasscollection.sample4;

import com.collectionStudy.lecture.app.firstclasscollection.sample3.Pay;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class NaverPays {

    private final List<Pay> pays;

}
