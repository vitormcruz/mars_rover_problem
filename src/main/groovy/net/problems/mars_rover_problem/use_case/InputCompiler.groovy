package net.problems.mars_rover_problem.use_case

/**
 * Compile all the inputs for the mars rover program.
 */
class InputCompiler {
    def PLATEAU_COORD_FORMAT = /^\d+ \d+$/
    def COORDINATE_MATCHER = /\d+/

    def compilePlateauCoordinates(String plateauCoordinates) {
        if (!(plateauCoordinates ==~ PLATEAU_COORD_FORMAT))
            throw new IllegalArgumentException("Plateau coordinates are in an invalid format. The right format " +
                                               " is formed by two numbers separated by a space, e.g.: 10 5")

        def match = plateauCoordinates =~ COORDINATE_MATCHER
        def coordinates = [:]
        coordinates.upperX = Integer.valueOf(match[0])
        coordinates.upperY = Integer.valueOf(match[1])
        return coordinates;
    }
}
