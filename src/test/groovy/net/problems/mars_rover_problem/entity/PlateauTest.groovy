package net.problems.mars_rover_problem.entity

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

class PlateauTest {

    public static final int VALID_COORDINATE = 5
    public static final int INVALID_COORDINATE = -1

    @Test
    void "create a new plateau with negative upperX coordinate should fail"(){
        shouldFail(XCoordinateCannotBeNegativeException, {new Plateau(INVALID_COORDINATE, VALID_COORDINATE)})
    }

    @Test
    void "create a new plateau with negative upperY coordinate should fail"(){
        shouldFail(YCoordinateCannotBeNegativeException, {new Plateau(VALID_COORDINATE, INVALID_COORDINATE)})
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
