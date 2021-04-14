package codingstudy.firstclasscollection;

import com.collectionStudy.lecture.app.firstclasscollection.sample3.Pay;
import com.collectionStudy.lecture.app.firstclasscollection.sample4.KakaoPays;
import com.collectionStudy.lecture.app.firstclasscollection.sample4.NaverPays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 컬렉션을_변수명으로 단점
 * 검색이 어려움
 *      네이버페이 그룹이 어떻게 사용되는지 검색 시 변수명으로만 검색할 수 있습니다
 *      이 상황에서 검색은 거의 불가능합니다.
 *      네이버페이의 그룹이라는 뜻은 개발자마다 다르게 지을 수 있기 때문입니다.
 *      네이버페이 그룹은 어떤 검색어로 검색이 가능할까요?
 * 명확한 표현이 불가능
 *      변수명에 불과하기 때문에 의미를 부여하기가 어렵습니다
 *      이는 개발팀/운영팀간에 의사소통시 보편적인 언어로 사용하기가 어려움을 얘기합니다.
 *      중요한 값임에도 이를 표현할 명확한 단어가 없는것이죠.
 */
public class NamedCollectionTest {

    @Test
    public void 컬렉션을_변수명으로() {
        //given
        List<Pay> naverPays = createNaverPays();
        List<Pay> kakaoPays = createKakaoPays();

    }

    @Test
    public void 일급컬렉션의_이름으로() {
        //given
        NaverPays naverPays = new NaverPays(createNaverPays());

        KakaoPays kakaoPays = new KakaoPays(createKakaoPays());

        //when

        //then
    }

    private ArrayList<Pay> createNaverPays() {
        return new ArrayList<>();
    }

    private ArrayList<Pay> createKakaoPays() {
        return new ArrayList<>();
    }
}
