import os
import sqlite3

base_dir = os.path.dirname(__file__)
database = os.path.join(base_dir,'data.sqlite')

conn = sqlite3.connect(database)
print('connect try')
print()

cur = conn.cursor()

drop_sql =""" DROP TABLE IF EXISTS items; """

cur.execute(drop_sql)
print(' (1) delete if exist target table. ')

create_sql = """ 
    CREATE TABLE items (
        item_id INTEGER PRIMARY KEY AUTOINCREMENT,
        item_name STRING UNIQUE NOT NULL,
        price INTEGER NOT NULL
    )
"""

cur.execute(create_sql)
print(' (2) table create.')
insert_sql = """
    INSERT INTO items
        (item_name, price)
    values
        (?,?)
"""

insert_data_list = [
    ('dango',100),('niku',150),('yaki',200)
]

cur.executemany(insert_sql, insert_data_list)
conn.commit()
print(' (3) data insert : execute. ')

select_all_sql ="""
    SELECT * FROM items
"""

cur.execute(select_all_sql)
print(' (4) -----all data select.------')
data = cur.fetchall()
print(data)


select_one_sql = """
    SELECT * FROM items WHERE item_id = ?
"""

id = 3

cur.execute(select_one_sql, (id,) )

print(data)

update_sql = """
    UPDATE items SET price =? WHERE item_id = ?
"""

price = 500
id = 1 
cur.execute(update_sql, (price, id) )

print(' (6) -------- data update:execute.--------')
conn.commit()
cur.execute(select_one_sql, (id,))
data = cur.fetchone()
print('check data of one : ',data)#line 072.

delete_sql = """
    DELETE FROM items WHERE item_id=?
"""

id=3
cur.execute(delete_sql, (id,))
conn.commit()

print('(7) ---- delete : execute ')
cur.execute(select_all_sql)
data = cur.fetchall()
print('delete execute :', data)

conn.close()
print()
print("the end")