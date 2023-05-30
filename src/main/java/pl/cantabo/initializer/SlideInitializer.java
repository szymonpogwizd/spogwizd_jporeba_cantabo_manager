package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.slide.SlideRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SlideInitializer {

    private final SlideRepository slideRepository;

    public void initialize() {
        slideRepository.insertSlide(
                UUID.fromString("09d7f388-0d59-48ea-a14b-31350a837b1d"),
                0,
                "<p>Bóg jest Światłością</p><p>I nie ma w Nim żadnej ciemności.</p><p>Jeżeli chodzimy w światłości,</p><p>Wtedy mamy łączność między sobą.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("a0f4c1cd-ea30-4591-b538-5840ec39b0e3"),
                1,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("5f8ca146-bf5d-4d2f-b336-0875e435f14d"),
                2,
                "<p>Krew Jezusa, Jego Syna,</p><p>Oczyszcza nas z wszelkiego grzechu.</p><p>Jeżeli mówimy, że nie mamy grzechu,</p><p>To samych siebie oszukujemy.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("d33552bc-3a4e-4348-b61f-e4dc1aa9db63"),
                3,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("a4c249d8-90d2-44f4-9546-c06b84c54e5e"),
                4,
                "<p>Jeżeli wyznajemy nasze grzechy,</p><p>Bóg oczyści nas z wszelkiej nieprawości.</p><p>Jeśliby nawet ktoś zgrzeszył,</p><p>Mamy Rzecznika wobec Ojca Jezusa Chrystusa.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("3d70e996-46d1-4061-a3be-d87db212734d"),
                5,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("4a12579c-6d78-45a8-b227-9e9ff80181c1"),
                0,
                "<p>Wśród nocnej ciszy głos się rozchodzi:</p><p>Wstańcie, pasterze, Bóg się wam rodzi</p><p>Czym prędzej się wybierajcie,</p><p>Do Betlejem pośpieszajcie,</p><p>Przywitać Pana.</p>",
                true,
                UUID.fromString("03785b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("b13370a1-91ac-4f11-86eb-04edc3ab4e65"),
                1,
                "<p>Poszli, znaleźli Dzieciątko w żłobie,</p><p>Z wszystkimi znaki, danymi sobie.</p><p>Jako Bogu cześć Mu dali,</p><p>A witając zawołali,</p><p>Z wielkiej radości.</p>",
                true,
                UUID.fromString("03785b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("12988016-365f-408d-a8e1-0159a0d64853"),
                2,
                "<p>„Ach witaj, Zbawco; z dawna żądany,</p><p>Tyle tysięcy lat wyglądany!</p><p>Na Ciebie króle, prorocy,</p><p>Czekali, a Tyś tej nocy –</p><p>Nam się objawił”.</p>",
                true,
                UUID.fromString("03785b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("2c46207e-faf6-480e-8571-703d3a3dc1b7"),
                3,
                "<p>I my czekamy na Ciebie, Pana,</p><p>A skoro przyjdziesz na głos kapłana.</p><p>Padniemy na twarz przed Tobą,</p><p>Wierząc, żeś jest pod osłoną,</p><p>Chleba i wina.</p>",
                true,
                UUID.fromString("03785b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("84245ef2-7356-4212-8811-6d63f73df663"),
                0,
                "Ach, mój Jezu, jak Ty klęczysz\nW Ogrójcu zakrwawiony!\nTam Cię Anioł w smutku cieszył,\nSkąd był świat pocieszony.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("0a946fb1-136e-4b11-bd47-2b07d6461e4e"),
                1,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("0fc9a267-6828-4bc6-9b94-7e7d1e0d2046"),
                2,
                "Ach, mój Jezu, jakeś srodze\nDo słupa przywiązany.\nZa tak ciężkie grzechy nasze\nOkrutnie biczowany.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("55f070f2-9a92-4e63-86e7-c2a9d547dc71"),
                3,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("61ce9e14-2fc1-4b89-9a91-08c6e049f784"),
                4,
                "Ach, mój Jezu, co za boleść\nCierpisz w ostrej koronie.\nTwarz najświętsza zakrwawiona,\nGłowa wszystka w krwi tonie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("668a0a59-0ae0-4e23-88d1-3b03b5aaf0be"),
                5,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("4f972b86-9c4c-4a34-9651-17c42438c523"),
                0,
                "Nie zna śmierci Pan żywota, chociaż przeszedł przez jéj wrota;\nrozerwała grobu pęta ręka święta. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("e9249064-c460-4e45-914e-0766922a3889"),
                1,
                "Adamie, twój dług spłacony, okup ludzi dokończony;\nwnijdziesz w niebo z szczęśliwymi dziećmi twymi. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("78b439fb-4e56-4df6-b24e-855a9f07a370"),
                2,
                "Próżno, żołnierze, strzeżecie, w tym grobie Go nie znajdziecie;\nwstał, przeniknął sklepu mury, Bóg natury. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("e7e699e9-d2b1-4f61-95db-5b8e8f411db9"),
                3,
                "On znowu na ludzkie plemię i na miłą patrzy ziemię.\nJak drogo dzisiaj przybrana, kosztem Pana! Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("543b9dd2-6315-4786-8f6d-1d13f2b790be"),
                4,
                "Przez Twe święte zmartwychwstanie, z grzechów powstać daj nam, Panie,\npotem z Tobą królowanie. Alleluja, Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("a6b09b3b-8bde-4f83-9481-c9e7245f0f68"),
                0,
                "Ty wyzwoliłeś nas Panie\nZ kajdan i samych siebie\nA Chrystus stając się bratem\nNauczył nas wołać do Ciebie:\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("162a0bcf-86d2-4d18-bdf9-4ff335d4ab4d"),
                1,
                "Bo Kościół jak drzewo życia\nW wieczności zapuszcza korzenie\nPrzenika naszą codzienność\nI pokazuje nam Ciebie\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("02b1f1f5-272c-4479-86a1-f520933acac7"),
                2,
                "Bóg hojnym Dawcą jest życia\nOn wyswobodził nas od śmierci\nI przygarniając do siebie\nUczynił swoimi dziećmi.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("e6b8eafa-5b82-42d2-b930-7cfa07e64604"),
                3,
                "Wszyscy jesteśmy braćmi\nJesteśmy jedną rodziną.\nTej prawdy nic już nie zaćmi\nI teraz jest jej godzina.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("c06f2be9-2c07-46a6-a4a0-70a4818d8a7d"),
                0,
                "Pan jest moim pasterzem, nie brak mi niczego.\nPozwala mi leżeć na zielonych pastwiskach.\nProwadzi mnie nad wody, gdzie mogę odpocząć:\norzeźwia moją duszę.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("00d369b7-197e-4b69-af02-3c1c67ef69de"),
                1,
                "Wiedzie mnie po właściwych ścieżkach\nprzez wzgląd na swoje imię.\nChociażbym chodził ciemną doliną,\nzła się nie ulęknę,\nbo Ty jesteś ze mną.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("e6a2e19c-af70-4001-8b61-96f6b3dd7d6a"),
                2,
                "Twój kij i Twoja laska\nsą tym, co mnie pociesza.\nStół dla mnie zastawiasz\nwobec mych przeciwników;\nnamaszczasz mi głowę olejkiem;\nmój kielich jest przeobfity.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("cf13c4fb-5d47-4599-bdb7-79b2e5e0cc02"),
                3,
                "Tak, dobroć i łaska pójdą w ślad za mną\nprzez wszystkie dni mego życia\ni zamieszkam w domu Pańskim\npo najdłuższe czasy.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );
    }
}
