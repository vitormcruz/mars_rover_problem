package net.problems.mars_rover_problem.use_case

import net.problems.mars_rover_problem.entity.Database

/**
 * Use case that deploy a single rover in a specified plateau
 */
class DeployRover {

    private UUID plateauId

    private LinkedHashMap<String, Object> instructions

    DeployRover(UUID plateauId, String roverDeployInstructions, InputCompiler inputCompiler) {
        instructions = inputCompiler.compileRoverDeployInstructions(roverDeployInstructions)
        this.plateauId = plateauId
    }

    def execute(){
        Database.INSTANCE
    }

}
