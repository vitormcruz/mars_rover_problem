package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.intefaceAdapter.InputCompiler
import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

class InputCompilerTest {

    private compiler = new InputCompiler();
    
    @Test
    void "compile an empty plateau coordinate initialization string"(){
        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("")})
    }

    @Test
    void "compile an invalid plateau coordinate initialization string"(){
        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("abc")})
    }

    @Test
    void "compile a plateau coordinate initialization string formed by strings instead of numbers"(){
        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("DD YY")})
    }

    @Test
    void "compile a plateau coordinate initialization string formed with more than two numbers"(){
        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("1 2 3")})
    }

    @Test
    void "compile a plateau coordinate initialization string formed with one number"(){
        shouldFail(IllegalArgumentException.class,
                   {compiler.compilePlateauCoordinates("1")})
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

    @Test
    void "compile an empty rover deploy information string"(){
        shouldFail(IllegalArgumentException.class, {compiler.compileRoverDeployInstructions("")})
    }

    @Test
    void "compile rover deploy information string with invalid coordinates"(){
        ["-11" ,"O"].each {
            shouldFail(IllegalArgumentException.class, {->compiler.compileRoverDeployInstructions("$it 5 N\nM")})
            shouldFail(IllegalArgumentException.class, {->compiler.compileRoverDeployInstructions("5 $it N\nM")})
        }
    }

    @Test
    void "compile a rover deploy information string with an invalid orientation string"(){
        def invalidOrientationRoverInfo = "5 10 O\nRMLMRMLRLMLRM"
        shouldFail(IllegalArgumentException.class, {compiler.compileRoverDeployInstructions(invalidOrientationRoverInfo)})
    }

    @Test
    void "compile a rover deploy information string with a valid orientation strings"(){
        def roverInfo = "5 10 ORIENTATION\nRMLMRMLRLMLRM"
        ["N", "S", "E", "W"].each {
            compiler.compileRoverDeployInstructions(roverInfo.replace("ORIENTATION", it))
        }
    }

    @Test
    void "compile a rover deploy information string with an invalid movement string"(){
        def invalidOrientationRoverInfo = "5 10 N\nO"
        shouldFail(IllegalArgumentException.class, {compiler.compileRoverDeployInstructions(invalidOrientationRoverInfo)})
    }

    @Test
    void "compile a rover deploy information string with a valid movement string"(){
        def roverInfo = "5 10 N\nMOVEMENT"
        ["L", "R", "M"].each {
            compiler.compileRoverDeployInstructions(roverInfo.replace("MOVEMENT", it))
        }
    }

    @Test
    void "compile a valid rover deploy information string"(){
        def instructions = compiler.compileRoverDeployInstructions("5 10 N\nRMLMRMLRLMLRM")
        instructions != null
        instructions.x == 5
        instructions.y == 10
        instructions.orientation = "N"
        instructions.movements == ["R", "M", "L", "M", "R", "M", "L", "R", "L", "M", "L", "R", "M"]
    }
}
