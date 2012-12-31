package acceptance

import net.problems.mars_rover_problem.use_case.CreateNewPlateau
import net.problems.mars_rover_problem.use_case.InputCompiler
import org.junit.Test

class CreatePlateauTest {

    public static final Integer VALID_PLATEAU_X_COORDINATE = 55
    public static final Integer VALID_PLATEAU_Y_COORDINATE = 101
    public static final String VALID_PLATEAU_COORDINATES_DEFINITION = "$VALID_PLATEAU_X_COORDINATE $VALID_PLATEAU_Y_COORDINATE"

    @Test
    def void create_plateau_with_valid_coordinates(){
        def plateau = new CreateNewPlateau(VALID_PLATEAU_COORDINATES_DEFINITION, new InputCompiler()).execute();
        assert plateau != null
        assert plateau.id != null
        assert plateau.upperX == VALID_PLATEAU_X_COORDINATE
        assert plateau.upperY == VALID_PLATEAU_Y_COORDINATE

    }
}
