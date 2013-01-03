package net.problems.mars_rover_problem.entity

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

class DatabaseTest {

    private Database database = Database.INSTANCE

    @Test
    def void "add a null plateau"(){
        shouldFail(IllegalArgumentException, {database.add(null)})
    }

    @Test
    def void "add plateau to a empty database"(){
        Plateau plateau = database.add(new Plateau(5, 5))
        plateau.id == 1
    }

    @Test
    def void "add plateau to a database with one element"(){
        database.add(new Plateau(5, 5))
        Plateau plateau = database.add(new Plateau(5, 5))
        plateau.id == 2
    }

    @Test
    def void "add plateau to a database with N elements"(){
        database.add(new Plateau(5, 5))
        database.add(new Plateau(5, 5))
        Plateau plateau = database.add(new Plateau(5, 5))
        plateau.id == 3
    }

    @Test
    def void "get a null plateau "(){
        shouldFail(IllegalArgumentException, {database.get(null)})
    }

    @Test
    def void "get a non existent plateau"(){
        Plateau plateau = database.get(1)
        plateau == null
    }

    @Test
    def void "get a plateau already added to the database"(){
        database.add(new Plateau(5, 5))
        Plateau plateau = database.get(1)
        plateau.id == 1
    }
}
