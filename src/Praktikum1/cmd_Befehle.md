

# Testen des NPlusEvenFilter

Aufruf in der CMD / Powershell: 
Im Ordner : .... \ADP\out\production\ADP
```
java ADP1.NumberGenerator 30 -5 5 | java ADP1.NPlusEvenFilter
java ADP1.NPlusEvenFilter < zahlen.txt // Unix/Linux
Get-Content .\ADP1\zahlen.txt | java ADP1.NPlusEvenFilter //Powershell... 
```

# WSL

Achtung: Wir entwickeln auf windows mit OpenJDK 18. 
Ich muss dieses erstmal in WSL installieren `sodu apt-get install openjdk-18-jdk`

```
# Pfad zu meinem Code
cd /mnt/c/Users/fabia/Documents/4_Semester/70_Algorithmen_Datenstrukturen/30_Praktika_Uebung/ADP/out/production/ADP
# Aufruf der Programme 
java ADP1.NumberGenerator 10 0 5

# Läuft noch nicht - er findet in WSL wieder algs4.jar nicht 
java ADP1.NPlusEvenFilter -classpath /mnt/c/Users/fabia/Documents/4_Semester/70_Algorithmen_Datenstrukturen/30_Praktika_Uebung/algs4/algs4.jar  

```


# 2024-04-24 

```powershell
java Praktikum1.NumberGenerator 20 -5 5 | java Praktikum1.NPlusEvenFilter 
java Praktikum1.NumberGenerator 20 -5 5 | java Praktikum1.NPlusEvenFilter | java Praktikum1.AccumulatorClient 0 
```

