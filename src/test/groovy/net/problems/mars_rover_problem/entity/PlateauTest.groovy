package net.problems.mars_rover_problem.entity

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail
import static net.problems.mars_rover_problem.constants.PlateauConstants.INVALID_COORDINATE
import static net.problems.mars_rover_problem.constants.PlateauConstants.VALID_COORDINATE

class PlateauTest {

    @Test
    void "create a new plateau with negative upperX coordinate should fail"(){
        shouldFail(IllegalArgumentException, {new Plateau(INVALID_COORDINATE, VALID_COORDINATE)})
    }

    @Test
    void "create a new plateau with negative upperY coordinate should fail"(){
        shouldFail(IllegalArgumentException, {new Plateau(VALID_COORDINATE, INVALID_COORDINATE)})
    }

    @Test
    void "create a new plateau with zero value coordinate"(){
        def plateau = new Plateau(0, 0)
        assert plateau.upperX == 0
        assert plateau.upperY == 0
    }

    @Test
    void "create a new plateau with non zero value valid coordinate"(){
        def plateau = new Plateau(VALID_COORDINATE, VALID_COORDINATE)
        assert plateau.upperX == VALID_COORDINATE
        assert plateau.upperY == VALID_COORDINATE
    }
}