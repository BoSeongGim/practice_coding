from flask import Flask, render_template

app = Flask(__name__)

#top page
@app.route('/')
def index():
    return render_template('top.html')


#list page
@app.route('/list')
def item_list():
    return render_template('list.html')

#detail page
@app.route('/detail')
def item_detail():
    return render_template('detail.html')


if __name__ == '__main__':
    app.run()