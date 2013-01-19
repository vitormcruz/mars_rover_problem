package net.problems.mars_rover_problem.external.delivery.console
import net.problems.mars_rover_problem.intefaceAdapter.InputCompiler
import net.problems.mars_rover_problem.use_case.LandRoversOnMarsPlateau

class SendRoversToMars {

    static private InputCompiler inputCompiler = new InputCompiler()

    public static void main(String []args){
        System.in.withReader {
            println "Gimme landing input!"
            def plateauInfo = inputCompiler.compilePlateauCoordinates(it.readLine())
            def roverInfo = extractRoverInfo(it)

            println "\n\nOUTPUT:"
            def output = new LandRoversOnMarsPlateau(plateauInfo, roverInfo).execute()
            for (def rover  : output.rovers) {
                println "$rover.x $rover.y $rover.orientation"
            }
        }
    }

    private static def extractRoverInfo(Reader it) {
        def roverInfo
        def roverCompiledInfo = []
        while ((roverInfo = it.readLine()).toLowerCase() != "x") {
            roverInfo += "\n" + it.readLine();
            roverCompiledInfo.add(inputCompiler.compileRoverDeployInstructions(roverInfo))
        }
        roverCompiledInfo
    }

}
