package acceptance
import net.problems.mars_rover_problem.use_case.LandRoversOnMarsPlateau
import org.junit.Test

class LandRoversOnMarsPlateauTest {

    @Test
    def void "Land a squad of rovers on a mars plateau"(){
        def plateau = [upperX: 55, upperY: 100]
        def roversInfo = [  [x:10, y:10, orientation: "S", movements: ["L", "M", "R"]],
                            [x:10, y:10, orientation: "N", movements: ["L", "M", "R"]],
                            [x:10, y:10, orientation: "E", movements: ["R", "M", "R"]],
                            [x:10, y:10, orientation: "W", movements: ["R", "M", "R"]]]

        def landingResult = new LandRoversOnMarsPlateau(plateau, roversInfo).execute();
        assert landingResult != null
        assert landingResult.plateau.upperX == 55
        assert landingResult.plateau.upperY == 100

        assert landingResult.rovers == [   [x: 11, y: 10, orientation: "S"],
                                           [x: 9, y: 10, orientation: "N"],
                                           [x: 10, y: 9, orientation: "W"],
                                           [x: 10, y: 11, orientation: "E"]]

    }

    @Test
    void "Land a rover outside of the plateau coordinates"(){
        def plateau = [upperX: 55, upperY: 100]
        def roversInfo = [  [x:55, y:100, orientation: "S", movements: ["L", "M", "R"]] ]
        GroovyAssert.shouldFail(IllegalArgumentException, {new LandRoversOnMarsPlateau(plateau,roversInfo).execute() })
    }

    @Test
    void "Move a rover to outside a plateau coordinate"(){
        def plateau = [upperX: 55, upperY: 100]
        def roversInfo = [  [x:55, y:100, orientation: "S", movements: ["L", "M", "R"]] ]
        GroovyAssert.shouldFail(IllegalArgumentException, {new LandRoversOnMarsPlateau(plateau,roversInfo).execute() })
    }

}
