package acceptance
import net.problems.mars_rover_problem.use_case.CreateNewPlateau
import net.problems.mars_rover_problem.use_case.InputCompiler
import org.junit.Test

import static net.problems.mars_rover_problem.use_case.PlateauConstants.*

class CreatePlateauTest {

    @Test
    def void "create plateau with valid coordinates"(){
        def plateau = new CreateNewPlateau(VALID_PLATEAU_COORDINATES_DEFINITION, new InputCompiler()).execute();
        assert plateau != null
        assert plateau.id != null
        assert plateau.upperX == VALID_PLATEAU_X_COORDINATE
        assert plateau.upperY == VALID_PLATEAU_Y_COORDINATE
    }
}
