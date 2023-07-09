//
// Created by Nivin Lawrence on 7/7/23.
//

#ifndef DESIGN_PRINCIPLES_SHAPE_H
#define DESIGN_PRINCIPLES_SHAPE_H

namespace abstract_pattern {
    // Shape is abstract class. A class is abstract if consists of one or more virtual functions.
    // Function with keyword virtual is virtual function. The virtual function in c++ helps
    // to define interface (thereby Type). Type declares set of procedures (methods or signatures)
    // supported by an object. An object can have more than one Types.
    class Shape {

    public:
        virtual void draw() = 0;

        virtual void describe() = 0;

        virtual float area() = 0;
    };
}

#endif //DESIGN_PRINCIPLES_SHAPE_H
