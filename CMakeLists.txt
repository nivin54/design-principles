cmake_minimum_required(VERSION 3.25)
project(design_principles)

set(CMAKE_CXX_STANDARD 17)

add_executable(design_principles main.cpp creational-pattern/shape.h creational-pattern/circle.cpp creational-pattern/circle.h creational-pattern/shape_factory.cpp creational-pattern/shape_factory.h)
