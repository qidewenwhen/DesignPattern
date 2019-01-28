# -*- coding: utf-8 -*-
import random
import abc

class Course(object):
	def get_lab(self):
		pass

	def __str__(self):
		pass

class BasicCourse(Course):
	def get_lab(self):
		return "basic_course: labs"

	def __str__(self):
		return "BasicCourse"

class ProjectCourse(Course):
	def  get_lab(self):
		return "project_course: labs"

	def __str__(self):
		return "ProjectCourse"

class Vm(object):
	def start(self):
		pass

class LinuxVm(Vm):
	def start (self):
		return "Linux vm running"

class MacVm(Vm):
	def start (self):
		return "Mac vm running"


class Factory(metaclass = abc.ABCMeta):
	@abc.abstractmethod
	def create_course(self):
		pass

	@abc.abstractmethod
	def create_vm(self):
		pass

class BasicCourseFactory(Factory):
	def create_course(self):
		return BasicCourse()

	def  create_vm(self):
		return LinuxVm()

class ProjectCourseFactory(Factory):
	def create_course(self):
		return ProjectCourse()

	def create_vm(self):
		return MacVm()


class SimpleCourseFactory(object):
	@staticmethod
	def create_course(type):
		if type == 'bc':
			return BasicCourse()
		elif type == 'pc':
			return ProjectCourse()

def get_factory():
	return random.choice([BasicCourseFactory, ProjectCourseFactory])()


if __name__ == '__main__':
	#t = random.choice(['bc', 'pc'])
	factory = get_factory();
	course = factory.create_course()
	vm = factory.create_vm()
	print(course.get_lab())
	print(vm.start())