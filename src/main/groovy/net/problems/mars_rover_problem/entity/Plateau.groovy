package net.problems.mars_rover_problem.entity

/**
 * A plateau where the mars rovers can explore.
 */
class Plateau {
    final Integer upperX
    final Integer upperY

    Plateau(Integer upperX, Integer upperY) {
        if(upperX < 0) throw new XCoordinateCannotBeNegativeException()
        if (upperY < 0) throw new YCoordinateCannotBeNegativeException()

        this.upperY = upperY
        this.upperX = upperX
    }
}
