package domain;

public class Superhero {
    private String navn;
    private String ægteNavn;
    private String superkraft;
    private int oprettelsesÅr;
    private String styrke;
    private boolean erMenneske;

    public Superhero(String navn, String ægteNavn, String superkraft, int oprettelsesÅr, String styrke, Boolean erMenneske) {
        this.navn = navn;
        this.ægteNavn = ægteNavn;
        this.superkraft = superkraft;
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

    public String getSuperkraft() {
        return superkraft;
    }

    public int getOprettelsesÅr() {
        return oprettelsesÅr;
    }

    public String getStyrke() {
        return styrke;
    }

    public void setSuperkraft(String superkraft) {
        this.superkraft = superkraft;
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
        return "Superhelt: " +  "\n" +
                "Navn: " + navn + "\n" +
                "Superheltens ægte navn: " + ægteNavn + "\n" +
                "Superheltens superkræft: " + superkraft +  "\n" +
                "Året din superhelt fik superkræfter: " + oprettelsesÅr +  "\n" +
                "Superheltens styrke: " + styrke +  "\n" +
                "Er din superhelt menneske: " + erMenneske;

    }
}
