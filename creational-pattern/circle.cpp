//
// Created by Nivin Lawrence on 7/7/23.
//

#include <iostream>
#include "circle.h"

namespace abstract_pattern {
    void Circle::draw() {
        std::cout << "Drawing circle.." << std::endl;
    }

    void Circle::describe() {
        std::cout << "Circle area is pi * radius * radius.";
    }

    float Circle::area() {
        return 0.1;
    }
}