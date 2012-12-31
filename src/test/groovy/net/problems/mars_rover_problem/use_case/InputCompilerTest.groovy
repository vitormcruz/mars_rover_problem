package net.problems.mars_rover_problem.use_case

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

class InputCompilerTest {

    private String INVALID_PLATEAU_COORD = "abc"
    private String PLATEAU_COORD_WITHOUT_NUMBERS = "DD YY"
    private String PLATEAU_COORD_WITH_TREE_NUMBERS = "1 2 3"
    private String PLATEAU_COORD_WITH_ONE_NUMBER = "1"

    @Test
    void "compile an empty plateau coordinate initialization string"(){
        def compiler = new InputCompiler();

        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("")})
    }

    @Test
    void "compile an invalid plateau coordinate initialization string"(){
        def compiler = new InputCompiler();

        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates(INVALID_PLATEAU_COORD)})
    }

    @Test
    void "compile a plateau coordinate initialization string formed by strings instead of numbers"(){
        def compiler = new InputCompiler();

        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates(PLATEAU_COORD_WITHOUT_NUMBERS)})
    }

    @Test
    void "compile a plateau coordinate initialization string formed with more than two numbers"(){
        def compiler = new InputCompiler();

        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates(PLATEAU_COORD_WITH_TREE_NUMBERS)})
    }

    @Test
    void "compile a plateau coordinate initialization string formed with one number"(){
        def compiler = new InputCompiler();

        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates(PLATEAU_COORD_WITH_ONE_NUMBER)})
    }

    @Test
    void "compile a plateau coordinate initialization with a well formed string of two low numbers"(){
        def compiler = new InputCompiler();
        def coordinates = compiler.compilePlateauCoordinates("1 2")
        assert coordinates.upperX == 1
        assert coordinates.upperY == 2
    }

    @Test
    void "compile a plateau coordinate initialization with a well formed string of two high numbers"(){
        def compiler = new InputCompiler();
        def coordinates = compiler.compilePlateauCoordinates("1111 2222")
        assert coordinates.upperX == 1111
        assert coordinates.upperY == 2222
    }

}
