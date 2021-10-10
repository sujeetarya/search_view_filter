package live.sujeetarya.searchviewfilter;

public class SuperheroModel {

    private String superHeroName;
    private String characterName;
    private String actorName;

    public SuperheroModel(String superHeroName, String characterName, String actorName) {
        this.superHeroName = superHeroName;
        this.characterName = characterName;
        this.actorName = actorName;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getActorName() {
        return actorName;
    }

}
