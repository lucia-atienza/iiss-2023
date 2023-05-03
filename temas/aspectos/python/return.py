import aspectlib

class StringTransformer:
    def reverse(self, s):
        return s[::-1]

@aspectlib.Aspect
def uppercase_output(self, s):
    result = yield aspectlib.Proceed
    yield aspectlib.Return(result.upper())

aspectlib.weave(StringTransformer.reverse, uppercase_output)

transformer = StringTransformer()
print(transformer.reverse("Hello, world!"))
