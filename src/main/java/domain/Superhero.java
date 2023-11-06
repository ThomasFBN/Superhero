package domain;

public class Superhero {
    private String navn;
    private String ægteNavn;
    private String superKræft;
    private int oprettelsesÅr;
    private String styrke;
    private boolean erMenneske;

    public Superhero(String navn, String ægteNavn, String superKræft, int oprettelsesÅr, String styrke, Boolean erMenneske) {
        this.navn = navn;
        this.ægteNavn = ægteNavn;
        this.superKræft = superKræft;
        this.oprettelsesÅr = oprettelsesÅr;
        this.styrke = styrke;
    }

    public String getNavn() {
        return navn;
    }

    public String getÆgteNavn() {
        return ægteNavn;
    }

    public boolean getErMenneske() {
        return erMenneske;
    }

    public String getSuperKræft() {
        return superKræft;
    }

    public int getOprettelsesÅr() {
        return oprettelsesÅr;
    }

    public String getStyrke() {
        return styrke;
    }

    public void setSuperKræft(String superKræft) {
        this.superKræft = superKræft;
    }

    public void setOprettelsesÅr(int oprettelsesÅr) {
        this.oprettelsesÅr = oprettelsesÅr;
    }

    public void setErMenneske(boolean erMenneske) {
        this.erMenneske = erMenneske;
    }

    public void setStyrke(String styrke) {
        this.styrke = styrke;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setÆgteNavn(String ægteNavn) {
        this.ægteNavn = ægteNavn;
    }

    @Override
    public String toString() {
        return "Superhelt: " +
                "Navn: " + navn + '\'' +
                " Superheltens ægte navn: " + ægteNavn + '\'' +
                " Superheltens superkræft: " + superKræft + '\'' +
                " Året din superhelt fik superkræfter: " + oprettelsesÅr +
                " Superheltens styrke: " + styrke + '\'' +
                " Er din superhelt menneske: " + erMenneske;

    }
}
