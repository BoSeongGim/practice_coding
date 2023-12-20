import mysql.connector

connection = mysql.connector.connect(host='localhost',port='5432',
                                     database='registration',
                                     user='root',
                                     password='amm3800D!')

cursor = connection.cursor()

select_Query = "select * from doctor"
cursor.execute(select_Query)
records = cursor.fetchall()
print("Total number of doctor in hospital are:", cursor.rowcount)
