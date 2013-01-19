package net.problems.mars_rover_problem.intefaceAdapter

class InvalidStringRoverDeployInstructionsFormat extends IllegalArgumentException{
    InvalidStringRoverDeployInstructionsFormat() {
        super("Rover deploy instructions are in an invalid format. The right format is formed by two lines. The first " +
                "is formed by two coordinates and the direction to witch the rover is pointing (N, S, E, W), each " +
                "separated by a space, e.g.: 10 5 N. The second line is formed by a list letters from the {L, R, M} " +
                "conjunct, e.g.: LMLMRM")
    }
}
