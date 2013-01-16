package net.problems.mars_rover_problem.entity
import org.junit.Test

import static net.problems.mars_rover_problem.entity.Orientation.E
import static net.problems.mars_rover_problem.entity.Orientation.N
import static net.problems.mars_rover_problem.entity.Orientation.S
import static net.problems.mars_rover_problem.entity.Orientation.W
import static org.mockito.Mockito.mock

class RoverTest {

    @Test
    void "rotate left from north"(){
        def rover = new Rover(0, 0, N , mock(Plateau));
        assert rover.rotateLeft().orientation == W
    }

    @Test
    void "rotate right from north"(){
        def rover = new Rover(0, 0, N , mock(Plateau));
        assert rover.rotateRight().orientation == E
    }

    @Test
    void "rotate left from south"(){
        def rover = new Rover(0, 0, S , mock(Plateau));
        assert rover.rotateLeft().orientation == E
    }

    @Test
    void "rotate right from south"(){
        def rover = new Rover(0, 0, S , mock(Plateau));
        assert rover.rotateRight().orientation == W
    }

    @Test
    void "rotate left from west"(){
        def rover = new Rover(0, 0, W , mock(Plateau));
        assert rover.rotateLeft().orientation == S
    }

    @Test
    void "rotate right from west"(){
        def rover = new Rover(0, 0, W , mock(Plateau));
        assert rover.rotateRight().orientation == N
    }

    @Test
    void "rotate left from east"(){
        def rover = new Rover(0, 0, E , mock(Plateau));
        assert rover.rotateLeft().orientation == N
    }

    @Test
    void "rotate right from east"(){
        def rover = new Rover(0, 0, E , mock(Plateau));
        assert rover.rotateRight().orientation == S
    }
}
