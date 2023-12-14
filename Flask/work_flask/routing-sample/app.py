from flask import Flask

#create instance 
app = Flask(__name__)

#routing(START)------------------------------
#top page
@app.route('/')
def index():
    return '<h1>TOP page</h1>'

#list page
@app.route('/list')
def item_list():
    return '<h1>Goods list page</h1>'

#detail page
@app.route('/detail')
def item_detail():
    return '<h1>Goods detail page</h1>'
#routing(END)--------------------------------

#execute web server
if __name__ == '__main__' :
    app.run()