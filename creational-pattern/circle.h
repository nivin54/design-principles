//
// Created by Nivin Lawrence on 7/7/23.
//

#include "shape.h"
#ifndef DESIGN_PRINCIPLES_CIRCLE_H
#define DESIGN_PRINCIPLES_CIRCLE_H

namespace abstract_pattern {
    class Circle : public Shape {
    public:
        void draw() override;

        void describe() override;

        float area() override;
    };

}
#endif //DESIGN_PRINCIPLES_CIRCLE_H
