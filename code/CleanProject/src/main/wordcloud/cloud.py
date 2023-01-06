import matplotlib.pyplot as plt
from wordcloud import WordCloud, STOPWORDS
from random import randint

"""
Pour installer:
matplotlib:
python -m pip install matplotlib
worldcloud:
-m pip install WordCloud

Fonctionement:
Le programme lit le fichier texte produit par le java.
Il séprare le texte par mot.
Ensuite il appel la bibliothèque que word_cloud qui renvoie une image
Le programme sauvegarde l'image avec saveimg
L'image sera supprimé dans le java ainsi que le text
"""

#permet de sauvegarder l'image
def saveimg(name):
	name = "src/main/wordcloud/" + name  +".png"
	plt.savefig(name)
	plt.clf()

#permet de génerer une couleur aléatoire
def couleur(*args, **kwargs):
    return "rgb({}, {}, {})".format(randint(0, 255), randint(0, 255), randint(0, 255))

#permet de lire l'image
txtArray = []
with open('src/main/wordcloud/text.txt') as file:
    #separe les lignes
	for line in file:
	    #separe les mots
		for word in line.split():
			txtArray.append(word)

#permet de convertir la liste de l'image en string
text = " ".join(i for i in txtArray)

#appel de la bibliothèque WordCloud pour créer l'image
word_cloud = WordCloud(
	width=3000,
	height=2000,
	random_state=1,
	background_color="white",
	colormap="Pastel1",
	collocations=False,
	stopwords=STOPWORDS,
).generate(text)

#affiche l'image
plt.imshow(word_cloud.recolor(color_func = couleur))
plt.axis("off")

#sauvegarde l'image
saveimg("cloud")