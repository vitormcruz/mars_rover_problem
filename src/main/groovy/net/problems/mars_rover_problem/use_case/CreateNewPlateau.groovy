package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Plateau

/**
 * Use case for the creation of a new plateau where the rovers will explore.
 */
class CreateNewPlateau {
    private Plateau plateau

    CreateNewPlateau(String plateauCoordinates, def inputCompiler) {
        def coordinates = inputCompiler.compilePlateauCoordinates(plateauCoordinates);
        plateau = new Plateau(coordinates.upperX, coordinates.upperY)
    }

    def execute(){
        plateau.properties
    }


}
