package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Database
import net.problems.mars_rover_problem.entity.Plateau
/**
 * Use case for the creation of a new plateau where the rovers will explore.
 */
class CreateNewPlateau {
    private final Plateau plateau
    private coordinates

    CreateNewPlateau(String plateauCoordinates, def inputCompiler) {
        coordinates = inputCompiler.compilePlateauCoordinates(plateauCoordinates)
    }

    def execute(){
        def addedPlateau = Database.INSTANCE.add(new Plateau(coordinates.upperX, coordinates.upperY))
        addedPlateau.properties
    }


}
