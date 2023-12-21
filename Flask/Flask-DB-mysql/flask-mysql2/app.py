#[execute in (venv)]                      # <step-1/4> source venv/bin/activate
from flask import Flask, render_template  # <step-2/4> pip install Flask
from mysql.connector import cursor        # <step-3/4> pip install mysql-connector-python
import mysql.connector

connection = mysql.connector.connect(host="localhost",port="3306",
                                     database="registration",
                                     user='root',password="amm3800D!")

cursor = connection.cursor()

app = Flask(__name__)

@app.route("/")
def index():
    return ""

@app.route("/registraion")
def python():
#    cursor.execute("select * from reg_memeber")
    cursor.execute("select * from reg_member;")
    value=cursor.fetchall()
    return render_template("registraion.html", data=value, name='python')
#    return render_template("registraion.html")



if __name__ =="__main__":  # <step-4/4> python3 app.py
    app.run(debug=True)

