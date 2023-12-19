#list 2.9
from flask import Flask

app = Flask(__name__)

@app.route('/dynamic/<value>')
def dynamic_default(value):
    print(f'type : {type(value)}, value:{value}')
    return f'<h1> value : [{value}] </h1>'

@app.route('/dynamic2/<int:number>')
def dynamic_converter(number):
    print(f'type : {type(number)}, value:{number}')
    return f'<h1> value(type int) : [{number}] </h1>'

@app.route('/dynamic3/<value>/<int:number>')
def dynamic_converter_multiple(value, number):
    print(f'type:{type(value)}, value:{value}')
    print(f'type:{type(number)}, value:{number}')
    return f'<h1> value : {value}, int : {number} </h1>'

if __name__ == '__main__':
    app.run()
