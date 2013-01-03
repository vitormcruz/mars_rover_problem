package net.problems.mars_rover_problem.entity

import groovy.test.GroovyAssert
import org.junit.Test

class DatabaseTest {

    @Test
    def void "add a null plateau"(){
        GroovyAssert.shouldFail(IllegalArgumentException, {Database.INSTANCE.add(null)})
    }

    @Test
    def void "add plateau to a empty database"(){
        Plateau plateau = Database.INSTANCE.add(new Plateau(5, 5))
        plateau.id == 1
    }

    @Test
    def void "add plateau to a database with one element"(){
        Database.INSTANCE.add(new Plateau(5, 5))
        Plateau plateau = Database.INSTANCE.add(new Plateau(5, 5))
        plateau.id == 2
    }

    @Test
    def void "add plateau to a database with N elements"(){
        Database.INSTANCE.add(new Plateau(5, 5))
        Database.INSTANCE.add(new Plateau(5, 5))
        Plateau plateau = Database.INSTANCE.add(new Plateau(5, 5))
        plateau.id == 3
    }
}
