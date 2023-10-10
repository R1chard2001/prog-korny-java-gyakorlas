# prog-korny-java-gyakorlas

## Gépkocsi osztály 

- **Rendszám**: szöveges adat, az osztályon kívül nem módosítható. Értéke nem lehet null
vagy üres string. Csak számokat, ékezetmentes nagybetűket és ’-’ karaktert tartalmazhat!
Pontosan 7 karakter hosszú! Az első három karakter csak betű, míg az utolsó három
karakter csak szám lehet. Az utolsó három karakter nem lehet csupa 0!

- **Évjárat**: egész típusú adat, kívülről nem módosítható. Értéke az [1950; 2023] intervallumban
érvényes. Értéke csak egyszer adható meg. Ha tudja, implementálja úgy, hogy az
intervallum felső határa a mindenkori aktuális évszám legyen! Ha ez nem megy, égesse be
a 2023-at!

- **Eredeti ár**: egész típusú adat, kívülről nem módosítható. Értéke a [300 000; 12 000 000]
intervallumban érvényes.

- **Állapot**: felsorolás típus, értékei: *Ujszeru*, *Megkimelt*, *Serult*, *Hibas*

- **Kor**: egész értékű, csak olvasható property. Értéke az aktuális év és az évjárat különbsége!

- **Extra ár**: egész értékű, csak olvasható property. Amennyiben a gépkocsi legfeljebb 2 éves
és újszerű, úgy az extra ár az eredeti ár 2%-a, egyébként 0Ft.

### Konstruktorok

- Készítsen konstruktort, mely az összes adatot (rendszám, évjárat, eredeti ár és állapot)
bekéri és eltárolja.

- Készítsen konstruktort, mely minden adatot bekér a gépkocsi állapotán kívül! Ezt az
előző konstruktor meghívásával automatikusan *megkíméltre* állítja!

### Függvények és eljárások

- Készítsen egész értékkel visszatérő késői kötésű metódust VetelAr néven a következők
szerint. A vételárhoz először meg kell állapítani mennyit amotrizálódik évente az autó az
állapotától függően.

| **Állapot** | **Amortizáció** |
|-------------|-----------------|
| Újszerű     | 9%              |
| Megkímélt   | 10%             |
| Sérült      | 11%             |
| Hibás       | 12%             |

- Írja felül a **ToString()** metódust úgy, hogy minden tárolt és számított adat ízlésesen
megjelenjen!

- Írja felül az **Equals()** metódust! Két gépkocsi akkor egyezik meg, ha ugyanaz a rendszámuk.

## Személygépkocsi osztály

- Hozzon létre osztályt Szemelygepkocsi néven, jelölje meg ősként a Gepkocsi osztályt és
implementálja benne az alábbiakat!

- **Szállítható személyek száma**: egész típusú adat, kívülről nem módosítható. Értéke a
{2, 4, 5, 7} halmaz valamely eleme.

- **Van vonóhorog**: logikai érték, nincs megkötés.

- **Klíma**: felsorolás típus, értékei: *Nincs*, *Manualis*, *Digitalis*, *DigitalisTobbzonas*

- Írja felül a Gepkocsi osztályban definiált extra ár property-t! A korábbi számítást
egészítse ki azzal, a vonóhorog ára 60 000Ft. Ha a szállítható személyek száma 7, az plusz
100 000Ft, a klímák ára pedig az alábbi táblázat alapján számolhatók.

| **Klíma**           | **Ár**          |
|---------------------|-----------------|
| Nincs               | 0 Ft            |
| Manuális            | 40 000 Ft       |
| Digitális           | 150 000 Ft      |
| Digitális többzónás | 350 000 Ft      |

### Konstruktorok

- Készítsen konstruktort, mely az összes adatot (rendszám, évjárat, eredeti ár, állapot,
szállítható személyek száma, vonóhorog és klíma) bekéri és eltárolja.

- Készítsen konstruktort, mely minden adatot bekér az gépkocsi állapotán és a klímán
kívül! Ezt az előző konstruktor meghívásával automatikusan megkíméltre és digitális-ra
(nem többzónás) állítja!

### Függvények és eljárások

- Írja felül a Gepkocsi osztályban definiált VetelAr metódust! Személygépkocsik esetén
az amortizáció az alábbiak szerint alakul.
Amennyiben a szállítható személyek száma 7, úgy az amortizáció mértékének számoljon
az 1,2-szeresével! A korábban megadott képletet használja itt is a vételár kiszámításához!

| **Állapot** | **Amortizáció** |
|-------------|-----------------|
| Újszerű     | 8%              |
| Megkímélt   | 9%              |
| Sérült      | 12%             |
| Hibás       | 13%             |

- Írja felül a **ToString()** metódust úgy, hogy minden tárolt és számított adat ízlésesen
megjelenjen!