def password(id):
    if len(id)>= 7 and len(id)<= 10:
        have_number = False
        have_alefba = False 
        for i in range (len(id)):
            char = id[i]
            try:
                int(char)
                have_number = True
                break
            except:
                pass
        if have_number:
            for char in id:
                if char.isalpha():
                    have_alefba = True
            if have_alefba:
                print("successful")
                return True
            else:
                return False
        else:
            return False
    else:
        if len(id)>= 7:
            print("more than 7")
            return False
        else:
            print("less than 10")
            return False
        
