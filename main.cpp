#include <iostream>

#include "creational-pattern/shape.h"
#include "creational-pattern/circle.h"
#include "creational-pattern/shape_factory.h"

using ::factory_pattern::ShapeFactory;
// using ::factory_pattern::ShapeFactory::ShapeType;
int main() {
    // Abstract class cannot be instantiated.
    ::abstract_pattern::Shape* shape = ShapeFactory::getShape(ShapeFactory::ShapeType::CIRCLE);
    shape->describe();
    return 0;
}
