package acceptance

import groovy.test.GroovyAssert
import net.problems.mars_rover_problem.use_case.CreateNewPlateau
import net.problems.mars_rover_problem.use_case.DeployRover
import net.problems.mars_rover_problem.use_case.InputCompiler
import org.junit.BeforeClass
import org.junit.Test

import static net.problems.mars_rover_problem.use_case.PlateauConstants.*

class DeployRoverTest {

    private static Map plateau

    @BeforeClass
    static void setupAll(){
        plateau = new CreateNewPlateau(VALID_PLATEAU_COORDINATES_DEFINITION, new InputCompiler()).execute()
    }


    @Test
    void "deploy rover outside of the plateau coordinates"(){
        GroovyAssert.shouldFail(IllegalArgumentException,
                {new DeployRover(plateau.id,
                                 "${VALID_PLATEAU_X_COORDINATE + 1} ${VALID_PLATEAU_Y_COORDINATE + 1} N\nLM",
                                 new InputCompiler()).execute()
                })

    }

    void "deploy rover in a valid plateau coordinate"(){

    }
}
