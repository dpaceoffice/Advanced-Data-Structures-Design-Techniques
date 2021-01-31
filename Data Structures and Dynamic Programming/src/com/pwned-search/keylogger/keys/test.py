class Test:

    testVar = 5

    def __init__(self):
        print("new test initiated")
    
    def __enter__(self):#self is a mem address of the new object
       return self
    
    def __exit__(self, ext_type, exc_value, traceback):
        return self, ext_type, exc_value, traceback
    #def __repr__(self):
     #   return "this is how we define objects"

if __name__ == "__main__":
    with Test() as obj:
        print("obj {}".format(obj))
   # with obj.__exit__()[0] as self, obj.__exit__()[1] as ext_type, obj.__exit__()[2] as traceback:
       # print("self {}".format(self))

obj = Test()
obj.testVar = 3
print(str(obj.testVar))
print('type: '+str(type(obj)))

obj2 = Test();
print(str(obj2.testVar))