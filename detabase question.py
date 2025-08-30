import sqlite3

stu = sqlite3.connect("student.db")
cursor = stu.cursor()
cursor.execute("""CREATE TABLE IF NOT EXISTS students(id INTEGER,name TEXT)""")
cursor.execute("INSERT INTO students(id,name) VALUES(?,?)", (12, "fara"))
cursor.execute("INSERT INTO students(id,name) VALUES(?,?)", (10, "dara"))
stu.commit()
cursor.execute('DELETE FROM students WHERE id = 10')
stu.commit()
cursor.execute("SELECT * FROM students")
all = cursor.fetchall()
for student in all:
    print(student)

cursor.close()