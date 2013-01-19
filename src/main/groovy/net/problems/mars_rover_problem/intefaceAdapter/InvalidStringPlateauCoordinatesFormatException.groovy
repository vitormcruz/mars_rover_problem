package net.problems.mars_rover_problem.intefaceAdapter

class InvalidStringPlateauCoordinatesFormatException extends IllegalArgumentException {
    InvalidStringPlateauCoordinatesFormatException() {
        super("Plateau coordinates are in an invalid format. The right format is formed by two numbers separated by a " +
              "space, e.g.: 10 5")
    }
}
