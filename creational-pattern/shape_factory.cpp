//
// Created by Nivin Lawrence on 7/8/23.
//

#include "shape_factory.h"

using ::abstract_pattern::Circle;
using ::abstract_pattern::Shape;
using ::factory_pattern::ShapeFactory;

Shape* ShapeFactory::getShape(ShapeFactory::ShapeType shape_type) {
    switch (shape_type) {
        case ShapeType::CIRCLE:
            return new Circle();
        default:
            return new Circle();
    }
}