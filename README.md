# Hausaufgabe 1

Deadline für Abgabe per Pull Request: 26.04.2023 23:59 Uhr. Außerdem ist zusätzlich eine persönliche Abnahme in der von Ihnen belegten Übungsgruppe notwendig, um zu bestehen. Bei unentschuldigtem Fehlen in der auf die Deadline folgenden Übung, wird die Hausaufgabe als nicht bestanden bewertet. 

## Aufgabenstellung

- Forken Sie dieses Repository (github.com/prog2-ss23/ha1) in Ihren eigenen GitHub Account.
- Analysieren Sie das Verhalten der Klasse `Calculator` und finden Sie ein paar Abweichungen im Vergleich zu [www.online-calculator.com](https://www.online-calculator.com/full-screen-calculator/) und/oder zu dem im JavaDoc beschriebenen Verhalten.
- Teilaufgabe 1: Schreiben Sie einen neuen zusätzlichen Test, der eine bisher nicht getestete Funktionalität abdeckt, die bereits funktioniert und der daher direkt grün wird.
- Teilaufgabe 2: Schreiben Sie zwei weitere zusätzliche Tests, die zwei unterschiedliche Fehlerkategorien aufdecken (d.h. deren Fehlerursachen in unterschiedlichen Methoden liegen) und somit fehlschlagen.
- Teilaufgabe 3: Schreiben Sie zwei Bugfixes (also Änderungen der Implementierungsklasse `Calculator`), so dass die zwei zuvor hinzugefügten Tests erfolgreich durchlaufen. Falls Sie dabei das Verhalten so erweitern, dass es über das im JavaDoc spezifizierte hinausgeht (aber zum Verhalten des Online Calculator passt), dann erweitern Sie bitte auch das JavaDoc entsprechend.
- Pushen Sie Ihre Tests & Änderungen auf Ihr eigenes, geforktes Repository, und zwar strukturiert in mindestens drei Commits: z.B. 1. Commit für neuer grüner Test, 2. Commit für neuer roter Test, 3. Commit für den Fix zu diesem Test, 4. Commit für weiteren neuen roter Test, 5. Commit für Fix zu diesem Test.
- Stellen Sie zum Abschluss einen Pull Request auf das obere Repository, und zwar vor der oben genannten Deadline.

## Hinweise

Sie dürfen mit Ihren Bugfixes die bestehende Implementierung deutlich verändern (z.B. die Verwendung der privaten Variablen), solange Sie dabei nicht die Signaturen (Name, Typ, Parameter) der öffentlichen Methoden ändern.
Sie dürfen auch gerne Hilfsmethoden hinzufügen, die intern von den öffentlichen Methoden aufgerufen werden, und diese internen Hilfsmethoden zum Zwecke der besseren Testbarkeit auch öffentlich (public) machen, um entsprechende Unit-Tests für diese Hilfsmethoden hinzufügen zu können.
