from flask import Flask, render_template
from mysql.connector import cursor
import mysql.connector

connection = mysql.connector.connect(host="localhost",port="3306",
                                     database="registration",
                                     user='root',password="********")
						 #password changed to * upload git.

cursor = connection.cursor()

app = Flask(__name__)

@app.route("/")
def index():
    return "welcome to Trinity software"

@app.route("/python")
def python():
#    cursor.execute("select * from reg_memeber")
    cursor.execute("select * from reg_member;")
    value=cursor.fetchall()
    return render_template("registraion.html", data=value, name='python')
#    return render_template("registraion.html")



if __name__ =="__main__":
    app.run(debug=True)

