import aspectlib

class Banco:
    def __init__(self):
        self.cuentas = []

    def agregar_cuenta(self, cuenta):
        self.cuentas.append(cuenta)
        print("Cuenta agregada al banco.")

@aspectlib.Aspect
def validar_saldo_inicial(self, cuenta):
    if cuenta.saldo_inicial >= 30:
        yield
        print("Saldo inicial válido.")
    else:
        yield
        print("Error: el saldo inicial debe ser mayor o igual a 30 euros.")

aspectlib.weave(Banco.agregar_cuenta, validar_saldo_inicial)

class Cuenta:
    def __init__(self, saldo_inicial, numero_cuenta):
        self.saldo_inicial = saldo_inicial
        self.numero_cuenta = numero_cuenta

banco = Banco()
cuenta1 = Cuenta(1000, 'ABCD1234')
cuenta2 = Cuenta(0, 'EFGH5678')

banco.agregar_cuenta(cuenta1)
banco.agregar_cuenta(cuenta2)
