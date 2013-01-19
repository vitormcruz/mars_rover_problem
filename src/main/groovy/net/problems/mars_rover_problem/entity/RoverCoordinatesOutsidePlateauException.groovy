package net.problems.mars_rover_problem.entity

class RoverCoordinatesOutsidePlateauException extends IllegalArgumentException{

    RoverCoordinatesOutsidePlateauException() {
        super("Rovers coordinates cannot exceed plateau bounds")
    }
}
