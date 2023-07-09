//
// Created by Nivin Lawrence on 7/8/23.
//

#include "shape.h"
#include "circle.h"
#ifndef DESIGN_PRINCIPLES_SHAPE_FACTORY_H
#define DESIGN_PRINCIPLES_SHAPE_FACTORY_H

namespace factory_pattern {
    class ShapeFactory {

    public:
        enum ShapeType {
            UNKNOWN = 0,
            CIRCLE = 1,
            RECTANGLE = 2
        };
        static abstract_pattern::Shape* getShape(ShapeType shape_type);
    };

}

#endif //DESIGN_PRINCIPLES_SHAPE_FACTORY_H
