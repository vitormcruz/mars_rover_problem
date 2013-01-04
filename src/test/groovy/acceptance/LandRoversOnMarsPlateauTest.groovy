package acceptance

import net.problems.mars_rover_problem.use_case.LandRoversOnMarsPlateau
import org.junit.Test

class LandRoversOnMarsPlateauTest {

    @Test
    def void "Land a squad of rovers on a mars plateau"(){
        def landingResult = new LandRoversOnMarsPlateau(55, 100).execute();
        assert landingResult != null
        assert landingResult.plateau.upperX == 55
        assert landingResult.plateau.upperY == 100

    }

//    @Test
//    void "deploy rover outside of the plateau coordinates"(){
//        GroovyAssert.shouldFail(IllegalArgumentException,
//                {new DeployRover(plateau.id,
//                                 "${VALID_PLATEAU_X_COORDINATE + 1} ${VALID_PLATEAU_Y_COORDINATE + 1} N\nLM",
//                                 new InputCompiler()).execute()
//                })
//
//    }
//
//    void "deploy rover in a valid plateau coordinate"(){
//
//    }
}
