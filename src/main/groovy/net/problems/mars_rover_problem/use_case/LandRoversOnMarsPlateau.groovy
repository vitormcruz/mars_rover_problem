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

    LandRoversOnMarsPlateau(def plateau, def roversInfo) {
        this.roversInfo = roversInfo
        this.plateauDTO = plateau
    }

    //TODO comment DTO info
    def execute(){
        def plateau = new Plateau(plateauDTO.upperX, plateauDTO.upperY)
        def rovers = []
        roversInfo.each { rooverInfo ->
            def rover = new Rover(rooverInfo.x, rooverInfo.y, Orientation.valueOf(rooverInfo.orientation), plateau)
            rooverInfo.movements.each { movementInfo ->
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

            rovers.add([x: rover.x, y: rover.y, orientation: rover.orientation.toString()])
        }
        [plateau: plateau.properties,
         rovers: rovers]
    }


}
