class Person:
    def __init__(self,full_name,age,salary,job,balance,history,married ):
        self.__name = full_name
        self.__age = age
        self.__salary = salary
        self.__job = job
        self.__balance = balance
        self.__history= history
        self.__married = married 
    
    def change_married(self):
        new_marriage_status = str(input("enter new marriage status: "))
        self.__married = new_marriage_status
        print("change successfully")
    def add_age(self):
        new_age = str(input("enter new age: "))
        self.__age = new_age
        print("change successfully")
    def change_salary(self):
        new_salary = float(input("enter new salary: "))
        self.__salary = new_salary
        print("change successfully")
    def pay(self):
        amount = float(input("enter amount of pay: "))
        self.__balance = self.__balance - amount
        print("successful")
    def person_method(self):
        while True:
            print("enetr 1 to change marriage status ")
            print("enter 2 to change age")
            print("3 to change salary")
            print("4 to change pay")
            print("else exit")
            action = int(input("enter action: "))
            if action == 1:
                self.change_married()
            elif action == 2:
                self.add_age()
            elif action == 3:
                self.change_salary()    
            elif action == 4:
                self.pay()
            else:
                break
while True: 
    print("enetr 1 to add person ")
    print("else to exit")
    action = int(input("enter action: "))
    if action== 1:
        full_name = str(input("enter name: "))
        age = str(input("enter age:"))
        salary = float(input("enter salary: "))
        job= str(input("enter job: "))
        balance = float(input("enter balance: "))
        history = str(input("enter history: "))
        married = str(input("enter marriage status: "))
        person = Person(full_name,age,salary,job,balance,history,married)
        person.person_method()
    else:
        break

