import pandas as pd 
import matplotlib.pyplot as plt
from wordcloud import WordCloud, STOPWORDS

def saveimg(name):
	name = "src/main/wordcloud/" + name  +".png"
	plt.savefig(name)
	plt.clf()

txtArray = []
with open('src/main/wordcloud/text.txt') as file:
	for line in file:
		for word in line.split():
			txtArray.append(word)

text = " ".join(i for i in txtArray)

word_cloud = WordCloud(
	width=3000,
	height=2000,
	random_state=1,
	background_color="salmon",
	colormap="Pastel1",
	collocations=False,
	stopwords=STOPWORDS,
).generate(text)

plt.imshow(word_cloud)
plt.axis("off")
saveimg("cloud")