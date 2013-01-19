package net.problems.mars_rover_problem.entity

class YCoordinateCannotBeNegativeException extends IllegalArgumentException{

    YCoordinateCannotBeNegativeException() {
        super("Y coordinate cannot be negative")
    }
}
