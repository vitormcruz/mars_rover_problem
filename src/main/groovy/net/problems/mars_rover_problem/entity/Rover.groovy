package net.problems.mars_rover_problem.entity

/**
 * Represents a rover deployed into a plateau of mars
 */
class Rover {
    final int x
    final int y
    final Orientation orientation
    final Plateau plateau

    Rover(Integer x, Integer y, Orientation orientation, Plateau plateau) {
        if (x < 0) throw new XCoordinateCannotBeNegativeException()
        if (y < 0) throw new YCoordinateCannotBeNegativeException()
        if (x > plateau.upperX || y > plateau.upperY) throw new RoverCoordinatesOutsidePlateauException()

        this.orientation = orientation
        this.plateau = plateau
        this.x = x
        this.y = y
    }

    Rover rotateLeft() {
        return new Rover(x, y, orientation.left, plateau)
    }

    Rover rotateRight() {
        return new Rover(x, y, orientation.right, plateau)
    }

    Rover moveForward() {
        def point = orientation.getPointOneStepFrom(x, y);
        return new Rover(point.x, point.y, orientation, plateau)
    }
}
