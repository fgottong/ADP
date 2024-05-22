import pandas as pd
import matplotlib.pyplot as plt
import matplotlib
import seaborn as sns

df = pd.read_csv('../../results.csv',sep=',', lineterminator='\n')
df.head(11)

# Diagram vorbereiten 

# Styledefinitionen für das Diagramm
sns.set(style="darkgrid")
matplotlib.rcParams['font.family'] = 'serif'
matplotlib.rcParams['font.size'] = 12


fig=plt.figure(figsize=(12,8))
ax = fig.add_axes()

# Legende,  Title, Achsenbeschriftungen im Diagramm anzeigen.
plt.title("gemessene Laufzeiten im Vergleich")
plt.gca().legend(title='Laufzeiten', loc="upper center")
plt.gca().set_xlabel("Anzahl der Elemente / Listengröße")
plt.gca().set_ylabel("Laufzeit in ms")
plt.gca().ticklabel_format(useMathText=True)

plt.plot()