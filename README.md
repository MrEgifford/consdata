# NewsForConsdataApp


Aplikacja wyświetlająca najnowsze wiadomości z poszczególnych krajów.
Zaimplementowana jako zadanie rekrutacyjne firmy Consdata

# Wymagania
- Java 8 (JDK)

# Zastosowane technologie
- Java 8
- Spring Boot
- Vue.js & Node
- Dozer
- Mockito
- Lombok
- Maven

# Struktura
Aplikacja składa się z dwóch warstw - frontend oraz backend. Warstwa backendowa zawiera logikę biznesową odpowiedzialną za przetwarzanie danych. Część frontendowa komunikuje się za pomocą wywołań REST z backendem oraz prezentacją zwróconych danych. Struktura projektu została tak zaprojektowana aby użytkownik mógł łatwo odnaleźć elementy przynależące do odpowiedniej wartstwy. W tym celu wszelkie pliki należące do warstwy backend zostały umieszczone w katalogu <code> backend</code> odpowiednio pliki frontendu w katalogu <code> frontend</code>

# Uruchomienie

W celu uruchomienia aplikacji należy uruchomić wykonywalny plik <code>NewsForConsdataApp.jar</code>. Można to zrobić na dwa sposoby:

- Uruchomić z lini poleceń
<code> java -jar NewsForConsdataApp.jar </code>
- Uruchomić za pomocą skryptu (Windows)
<code>startApp.cmd</code>

Aplikacja po uruchomieniu się dostępna będzie pod adresem <code>http://localhost:8080/</code>

# Dla developera

Możesz także zbudować aplikację u siebie na komputerze lokalnie. W tym celu najlepiej sklonować projekt na dysk.

<code>clone https://github.com/MrEgifford/consdata.git ConsdataTask</code>

 a także uruchomić w katalogu głównym aplikacji (<code>C:/.../ConsdataTask</code>) komendę:

<code>mvn clean install</code>

Wykonywalny plik <code>NewsForConsdataApp.jar</code> zostanie umiejscowiony w katalogu głównym aplikacji: <code>ConsdataTask</code>.

# Dokumentacja
Projekt posiada automatycznie generowaną dokumentację dostępnego REST API. Generowanie następuje podczas budowania aplikacji (</code>mvn install </code>) i znajduje się w tworzonym przez Maven katalogu <code>backend/target/generated-docs</code>
