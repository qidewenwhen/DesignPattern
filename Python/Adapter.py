class OldCourse(object):
	def show(self):
		print("show description")
		print("show teacher of course")
		print("show labs")

class Page(object):
	def __init__(self, course):
		self.course = course

	def render(self):
		self.course.show()

class NewCourse(object):
	def show_desc(self):
		print("show new description")

	def show_teacher(self):
		print("show new teacher of course")

	def show_labs(self):
		print("show new labs")

class Adapter(OldCourse):
	def __init__(self, course):
		self.course = course;

	def show(self):
		self.course.show_desc();
		self.course.show_teacher();
		self.course.show_labs();

if __name__ == '__main__':
	old_course = OldCourse();
	page = Page(old_course);
	page.render()
	print("------------------------------")
	adapter = Adapter(NewCourse());
	page = Page(adapter);
	page.render();