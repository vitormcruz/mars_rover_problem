package net.problems.mars_rover_problem.entity

/**
 * Represents a rover deployed into a plateau of mars
 */
class Rover {
    final int x
    final int y
    final Orientation orientation
    final Plateau plateau

    //TODO use specific exception always
    Rover(Integer x, Integer y, Orientation orientation, Plateau plateau) {
        if (x < 0) throw new IllegalArgumentException("Rovers x coordinate cannot be negative")
        if (y < 0) throw new IllegalArgumentException("Rovers y coordinate cannot be negative")
        if (x > plateau.upperX) throw new IllegalArgumentException("Rovers x coordinate cannot exceed plateau upperX coordinate")
        if (y > plateau.upperX) throw new IllegalArgumentException("Rovers y coordinate cannot exceed plateau upperY coordinate")

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
