package net.problems.mars_rover_problem.intefaceAdapter
/**
 * Compile all the inputs for the mars rover program.
 */
class InputCompiler {
    public static final COORD_FORMAT = /$POINT_FORMAT $POINT_FORMAT/
    public static final POINT_FORMAT = /(\d+)/
    public static final String ROVER_MOVEMENT_FORMAT = "([LMR]+)"
    public static final String ROVER_ORIENTATION_FORMAT = "([NSEW])";
    public static final String ROVER_POSITION_FORMAT = "$COORD_FORMAT $ROVER_ORIENTATION_FORMAT"
    public static final String ROVER_DEPLOY_INFO_FORMAT = "$ROVER_POSITION_FORMAT\\n" +
                                                          "$ROVER_MOVEMENT_FORMAT"

    /**
     * Compile the informed plateauCoordinates and return a map with the plateau coordinates. plateauCoordinates is
     * formed by two numbers separated by a space, e.g.: 10 5.
     *
     * <p>
     * Returned DTO:
     *  <pre>
     *      [upperX:N as Integer,
     *       upperY:N as Integer]
     *  </pre>
     *
     * @return A map with the plateau information.
     * @throws InvalidStringPlateauCoordinatesFormat if the plateauCoordinates parameter is in an invalid format
     */
    def compilePlateauCoordinates(String plateauCoordinates) {
        if (!(plateauCoordinates ==~ COORD_FORMAT))
            throw new InvalidStringPlateauCoordinatesFormat()

        def match = plateauCoordinates =~ COORD_FORMAT
        [upperX:match[0][1] as Integer,
         upperY:match[0][2] as Integer]
    }

    /**
     * Compile the informed roverDeployInstructions and return a map with the compiled rover deploy instructions.
     * roverDeployInstructions is formed by two coordinates and the direction to witch the rover is pointing
     * (N, S, E, W), each separated by a space, e.g.: 10 5 N. The second line is formed by a list letters from
     * the {L, R, M} conjunct, e.g.: LMLMRM".
     *
     * <p>
     * Returned DTO:
     *
     * <pre>
     *   [x:            N as Integer,
     *    y:            N as Integer,
     *    orientation:  One of ('N', 'S', 'E', 'W'),
     *    movements:    List of ('L', 'R', 'M')]
     * </pre>
     *
     * @return A map with the compiled deploy instructions.
     * @throws InvalidStringRoverDeployInstructionsFormat if the roverDeployInstructions parameter is in an invalid format.
     */
    def compileRoverDeployInstructions(String roverDeployInstructions) {
        if (!(roverDeployInstructions ==~ ROVER_DEPLOY_INFO_FORMAT))
            throw new InvalidStringRoverDeployInstructionsFormat()

        def position = roverDeployInstructions =~ ROVER_DEPLOY_INFO_FORMAT
        [x:            position[0][1] as Integer,
         y:            position[0][2] as Integer,
         orientation: position[0][3],
         movements:    position[0][4] as List]
    }
}
