package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Plateau

/**
 * Use case for the creation of a new plateau where the rovers will explore.
 */
class LandRoversOnMarsPlateau {
    private Plateau plateau

    LandRoversOnMarsPlateau(Integer upperX, Integer upperY) {
        plateau = new Plateau(upperX, upperY)
    }

    //TODO comment DTO info
    def execute(){
        [plateau: plateau.properties]
    }


}
