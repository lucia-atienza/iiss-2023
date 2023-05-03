import aspectlib

class Calculator:
    def add(self, a, b):
        return a + b

@aspectlib.Aspect
def log_addition(self, a, b):
    print(f"Sumando {a} y {b}")
    result = yield aspectlib.Proceed
    print(f"Resultado: {result}")

aspectlib.weave(Calculator.add, log_addition)

calculator = Calculator()
calculator.add(2, 3)
