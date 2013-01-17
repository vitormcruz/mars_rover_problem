package net.problems.mars_rover_problem.entity

import org.junit.BeforeClass
import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail
import static net.problems.mars_rover_problem.entity.Orientation.*
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class RoverTest {

    private static Plateau plateau = mock(Plateau)

    @BeforeClass
    static void setupForClass(){
        when(plateau.upperX).thenReturn(100)
        when(plateau.upperY).thenReturn(100)
    }

    @Test
    void "create rover outside x coordinate from plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(9)
        shouldFail(IllegalArgumentException, { new Rover(10, 10, N, plateau)})
    }

    @Test
    void "create rover outside y coordinate from plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperY).thenReturn(9)
        shouldFail(IllegalArgumentException, { new Rover(10, 10, N, plateau)})
    }

    @Test
    void "create rover outside x and y coordinates from plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(9)
        when(plateau.upperY).thenReturn(9)
        shouldFail(IllegalArgumentException, { new Rover(10, 10, N, plateau)})
    }

    @Test
    void "create rover with a negative x coordinate"(){
        shouldFail(IllegalArgumentException, { new Rover(-1, 10, N, plateau)})
    }

    @Test
    void "create rover with a negative y coordinate"(){
        shouldFail(IllegalArgumentException, { new Rover(10, -1, N, plateau)})
    }

    @Test
    void "rotate left from north"(){
        def rover = new Rover(0, 0, N , plateau);
        assert rover.rotateLeft().orientation == W
    }

    @Test
    void "rotate right from north"(){
        def rover = new Rover(0, 0, N , plateau);
        assert rover.rotateRight().orientation == E
    }

    @Test
    void "rotate left from south"(){
        def rover = new Rover(0, 0, S , plateau);
        assert rover.rotateLeft().orientation == E
    }

    @Test
    void "rotate right from south"(){
        def rover = new Rover(0, 0, S , plateau);
        assert rover.rotateRight().orientation == W
    }

    @Test
    void "rotate left from west"(){
        def rover = new Rover(0, 0, W , plateau);
        assert rover.rotateLeft().orientation == S
    }

    @Test
    void "rotate right from west"(){
        def rover = new Rover(0, 0, W , plateau);
        assert rover.rotateRight().orientation == N
    }

    @Test
    void "rotate left from east"(){
        def rover = new Rover(0, 0, E , plateau);
        assert rover.rotateLeft().orientation == N
    }

    @Test
    void "rotate right from east"(){
        def rover = new Rover(0, 0, E , plateau);
        assert rover.rotateRight().orientation == S
    }

    @Test
    void "move forward to north"(){
        def rover = new Rover(10, 10, N , plateau);
        def movedRover = rover.moveForward()
        assert movedRover.x == 10
        assert movedRover.y == 11
    }

    @Test
    void "move forward to north twice"(){
        def rover = new Rover(10, 10, N , plateau);
        def movedRover = rover.moveForward().moveForward()
        assert movedRover.x == 10
        assert movedRover.y == 12
    }

    @Test
    void "move forward to north at the edge of the plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(100)
        when(plateau.upperY).thenReturn(10)
        def rover = new Rover(10, 10, N , plateau);
        shouldFail(IllegalArgumentException, { rover.moveForward() })
    }

    @Test
    void "move forward to south"(){
        def rover = new Rover(10, 10, S , plateau);
        def movedRover = rover.moveForward()
        assert movedRover.x == 10
        assert movedRover.y == 9
    }

    @Test
    void "move forward to south twice"(){
        def rover = new Rover(10, 10, S , plateau);
        def movedRover = rover.moveForward().moveForward()
        assert movedRover.x == 10
        assert movedRover.y == 8
    }

    @Test
    void "move forward to south at the edge of the plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(100)
        when(plateau.upperY).thenReturn(0)
        def rover = new Rover(0, 0, S , plateau);
        shouldFail(IllegalArgumentException, { rover.moveForward() })
    }

    @Test
    void "move forward to west"(){
        def rover = new Rover(10, 10, W , plateau);
        def movedRover = rover.moveForward()
        assert movedRover.x == 9
        assert movedRover.y == 10
    }

    @Test
    void "move forward to west twice"(){
        def rover = new Rover(10, 10, W , plateau);
        def movedRover = rover.moveForward().moveForward()
        assert movedRover.x == 8
        assert movedRover.y == 10
    }

    @Test
    void "move forward to west at the edge of the plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(0)
        when(plateau.upperY).thenReturn(100)
        def rover = new Rover(0, 0, W , plateau);
        shouldFail(IllegalArgumentException, { rover.moveForward() })
    }

    @Test
    void "move forward to east"(){
        def rover = new Rover(10, 10, E , plateau);
        def movedRover = rover.moveForward()
        assert movedRover.x == 11
        assert movedRover.y == 10
    }

    @Test
    void "move forward to east twice"(){
        def rover = new Rover(10, 10, E , plateau);
        def movedRover = rover.moveForward().moveForward()
        assert movedRover.x == 12
        assert movedRover.y == 10
    }

    @Test
    void "move forward to east at the edge of the plateau"(){
        def plateau = mock(Plateau)
        when(plateau.upperX).thenReturn(10)
        when(plateau.upperY).thenReturn(100)
        def rover = new Rover(10, 10, E, plateau);
        shouldFail(IllegalArgumentException, { rover.moveForward() })
    }
}
