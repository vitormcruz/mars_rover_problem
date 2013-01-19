package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Orientation
import net.problems.mars_rover_problem.entity.Plateau
import net.problems.mars_rover_problem.entity.Rover

/**
 * Use case for the creation of a new plateau where the rovers will explore.
 */
class LandRoversOnMarsPlateau {

    private def plateauDTO
    private def roversInfo

    /**
     * Parameters expected:
     *
     * <pre>
     *     plateau ->    [upperX:N as Integer,
     *                    upperY:N as Integer]
     *
     *     roversInfo -> A list of [x:            N as Integer,
     *                              y:            N as Integer,
     *                              orientation:  One of ('N', 'S', 'E', 'W'),
     *                              movements:    List of ('L', 'R', 'M')]
     *
     * </pre>
     *
     */
    LandRoversOnMarsPlateau(def plateau, def roversInfo) {
        this.roversInfo = roversInfo
        this.plateauDTO = plateau
    }

    /**
     * Execute the landing with the given information
     *
     * <p>
     * Returned DTO:
     * <pre>
     *   [plateau: P,
     *   rovers: rovers]
     *
     *   P -> [upperX:N as Integer,
     *         upperY:N as Integer]
     *
     *   For each rover -> [x: rover.x, y: rover.y, orientation: rover.orientation]
     * </pre>
     *
     * @return A map containing the plateau information along with the rovers positions and orientations after its
     * movements.
     */
    def execute(){
        def plateau = new Plateau(plateauDTO.upperX, plateauDTO.upperY)
        def rovers = []
        roversInfo.each { roverInfo ->
            def rover = new Rover(roverInfo.x, roverInfo.y, Orientation.valueOf(roverInfo.orientation), plateau)
            roverInfo.movements.each { movementInfo ->
                switch (movementInfo){
                    case "L":
                        rover = rover.rotateLeft()
                        break

                    case "R":
                        rover = rover.rotateRight()
                        break

                    case "M":
                        rover = rover.moveForward()
                        break
                }
            }

            rovers.add([x: rover.x, y: rover.y, orientation: rover.orientation as String])
        }
        [plateau: plateau.properties,
         rovers: rovers]
    }


}
