package net.problems.mars_rover_problem.entity

enum Orientation {
    N ("W", "E"),
    S ("E", "W"),
    E ("N", "S"),
    W ("S", "N")

    Orientation left
    private String left
    Orientation right
    private String right

    Orientation(String left, String right){
        this.left = left
        this.right = right
    }

    Orientation getLeft() {
        return Orientation.valueOf(left)
    }

    Orientation getRight() {
        return Orientation.valueOf(right)
    }
}