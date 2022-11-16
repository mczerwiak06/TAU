Testy Selenium zrealizowano dla dwóch różnych serwisów internetowych: onet.pl i teufelaudio.pl
Do testów wykorzystano webdriver - chromedriver dla przeglądarki Chrome i geckodriver dla przeglądarki Firefox
Testy zostały napisane w Pythonie na Mac OS. Aby zadziałały należy podać poprawna ścieżkę dostępu do webdriver'a

Scenariusze:

Scenariusz 1 - Firefox

Dodanie produktu do koszyka na stronie „https://teufelaudio.pl" i sprawdzenie czy jest tam faktycznie widoczny.

1. Idziemy na stronę https://teufelaudio.pl.
2. Zatwierdzamy wszystkie ciasteczka.
3. Wchodzimy w zakładkę „Sale”.
4. Na liście produktów wyszukujemy produktu „Cinebar 11 2.1 Set”.
5. Klikamy w nazwę produktu „Cinebar 11 2.1-Set”.
6. Klikamy przycisk dodawania do koszyka.
7. Po dodaniu do koszyka wyskakuje okienko, w którym klikamy przycisk „Koszyk”
8. Przechodzimy do widoku koszyka
9. Sprawdzamy czy produkt został prawidłowo dodany do koszyka.

Scenariusz 2 - Chrome

Wejście na stronę Onet.pl, przejrzenie wiadomości, wyszukiwanie po słowie i próba zalogowania

1. Idziemy na stronę https://onet.pl.
2. Zatwierdzamy wszystkie ciasteczka.
3. Przechodzimy w zakładkę „Wiadomości”.
4. W polu wyszukiwania wpisujemy „Onet”.
5. Z listy wyników wyszukiwania wybieramy wyszukanie na pierwszej pozycji i klikamy w nie.
6. Po przejściu do strony głównej klikamy w ikonkę „Poczta”.
7. W pole Adres email wpisujemy: „test@ok.pl"
8. W pole „Hasło” wpisujemy: „1234”.
9. Klikamy „Zaloguj”.
10. Sprawdzamy czy pojawił się element z napisem „Nieprawidłowy email lub hasło” lub brak takiego elementu w przypadku pojawienia się captcha. 
