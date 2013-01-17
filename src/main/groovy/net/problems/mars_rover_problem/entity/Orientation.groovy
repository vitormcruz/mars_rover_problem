package net.problems.mars_rover_problem.entity

enum Orientation {
    N ("W", "E", [x: 0, y: 1]),
    S ("E", "W", [x: 0, y: -1]),
    E ("N", "S", [x: 1, y: 0]),
    W ("S", "N", [x: -1,y:  0])

    Orientation left
    private String left
    Orientation right
    private String right
    def addToPoint



    Orientation(String left, String right, def addToPoint){
        this.left = left
        this.right = right
        this.addToPoint = addToPoint
    }

    Orientation getLeft() {
        Orientation.valueOf(left)
    }

    Orientation getRight() {
        Orientation.valueOf(right)
    }

    def getPointOneStepFrom(Integer x, Integer y) {
        [x: x + addToPoint.x , y: y + addToPoint.y]
    }
}