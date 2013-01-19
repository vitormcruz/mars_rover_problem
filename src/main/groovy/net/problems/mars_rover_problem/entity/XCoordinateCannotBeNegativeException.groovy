package net.problems.mars_rover_problem.entity

class XCoordinateCannotBeNegativeException extends IllegalArgumentException{

    XCoordinateCannotBeNegativeException() {
        super("X coordinate cannot be negative")
    }
}
