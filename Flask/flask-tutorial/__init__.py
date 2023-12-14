from flask import Flask

app = Flask(__name__)

@app.route("/")
def helloworld():
    return "hello, again"

@app.route("/board/<article_id>")
def board(article_id):
    return "looking board number : {}".format(article_id)


if __name__ == "__main__":
	app.run()