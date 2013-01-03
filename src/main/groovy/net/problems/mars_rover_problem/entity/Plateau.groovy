package net.problems.mars_rover_problem.entity

import groovy.transform.EqualsAndHashCode

/**
 * A plateau where the mars rovers can explore.
 */
@EqualsAndHashCode
class Plateau {
    final Integer id;
    final Integer upperX
    final Integer upperY

    private Plateau(Integer id, Plateau copy) {
        this.id = id;
        upperX = copy.upperX
        upperY = copy.upperY
    }

    Plateau(Integer upperX, Integer upperY) {
        if(upperX < 0 || upperY < 0)
            throw new IllegalArgumentException("upperX and upperY can only have non-negative values.")

        this.upperY = upperY
        this.upperX = upperX
    }

    Plateau setId(Integer id) {
        new Plateau(id, this)
    }
}
