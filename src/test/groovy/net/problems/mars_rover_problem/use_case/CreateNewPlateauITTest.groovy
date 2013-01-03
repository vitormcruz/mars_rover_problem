package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Database
import org.junit.Test

class CreateNewPlateauITTest {

    @Test
    def void "get newly created plateau from database"(){
        def plateau = new CreateNewPlateau(PlateauConstants.VALID_PLATEAU_COORDINATES_DEFINITION, new InputCompiler()).execute();
        def plateauRecovered = Database.INSTANCE.get(plateau.id);
        plateauRecovered.id == 1
        plateauRecovered == plateau
    }
}
