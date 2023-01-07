import matplotlib.pyplot as plt
from wordcloud import WordCloud, STOPWORDS
from random import randint

"""
Pour installer:
voir scripts

matplotlib:
python -m pip install matplotlib
worldcloud:
python -m pip install WordCloud

Fonctionement:
Le programme lit le fichier texte produit par la classe java cloudWordGenerator.
Il séprare le texte par mot.
Ensuite il appel la bibliothèque word_cloud qui renvoie une image
Le programme sauvegarde l'image avec la méthode saveimg
L'image et le texte créés seront suprimés lors de l'action sur le bouton retour
"""

#permet de sauvegarder l'image
def saveimg(name):
	name = "src/main/wordcloud/" + name  +".png"
	plt.savefig(name)
	plt.clf()

#permet de génerer une couleur aléatoire
def couleur(*args, **kwargs):
    return "rgb({}, {}, {})".format(randint(0, 255), randint(0, 255), randint(0, 255))

#permet de lire le texte et de placer les mots un par un dans une liste
txtArray = []
with open('src/main/wordcloud/text.txt') as file:
    #separe les lignes
	for line in file:
	    #separe les mots
		for word in line.split():
			txtArray.append(word)

#permet de convertir la liste de mots en string, chaque mot est séparé du précédent par un espace
text = " ".join(i for i in txtArray)

#appel de la bibliothèque WordCloud pour créer l'image
word_cloud = WordCloud(
	width=600,
	height=345,
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