package net.problems.mars_rover_problem.entity

public enum Database {
    INSTANCE;

    private List<Plateau> plateaus = [];

    def Plateau add(Plateau plateau){
        if (plateau == null) throw new IllegalArgumentException("Cannot add a null plateau to the database.")
        def size = plateaus.size();
        def persistedPlateau = plateau.setId(size + 1)
        plateaus.add persistedPlateau
        return persistedPlateau
    }
}