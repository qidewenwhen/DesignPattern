class Singleton(object):
	class _A(object):
		def __init__(self):
			pass

		def display(self):
			return id(self)

	_instance = None

	def __init__(self):
		if Singleton._instance is None:
			Singleton._instance = Singleton._A()

	def __getattr__(self, attr):
		return getattr(self._instance, attr)

class Singleton:
	def __init__(self, cls):
		self._cls = cls

	def Instance(self):
		try:
			return self._instance
		except AttributeError:
			self._instance = self._cls()
			return self._instance

	def __call__(self):
		raise TypeError('Singleton must be accessed through `Instance()`.')

	def __instancecheck__(self, inst):
		return isinstance(inst, self._decorated)

@Singleton
class A:
	def __init__(self):
		pass

	def display(self):
		return id(self)

if __name__ == '__main__':
#	s1 = Singleton()
#	s2 = Singleton()
	s1 = A.Instance()
	s2 = A.Instance()
	print(s1, s1.display())
	print(s2, s2.display())
