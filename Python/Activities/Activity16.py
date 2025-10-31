class Car():
    def __init__(self, manufacturer1, model1, make1, transmission1, color1):
        self.manufacturer=manufacturer1
        self.model=model1
        self.make=make1
        self.transmission=transmission1
        self.color =color1
    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")
    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")


	
car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")
 
car1.accelerate()
car1.stop()
