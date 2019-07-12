package builderexample;

class Pasta {
    public String pastatype = "";
    public String sauce = "";
    public String spice = "";

    public void setPastatype(String pastatype) {
        this.pastatype = pastatype;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setSpice(String spice) {
        this.spice = spice;
    }
}

abstract class PastaBuilder {
    protected Pasta pasta;

    public Pasta getPasta() {
        return pasta;
    }

    public void createNewPastaProduct() {
        pasta = new Pasta();
    }

    public abstract void buildPastatype();
    public abstract void buildSauce();
    public abstract void buildSpice();
}

class BolognesePastaBuilder extends PastaBuilder {
    public void buildPastatype() {
        pasta.setPastatype("spaghetti");
    }

    public void buildSauce() {
        pasta.setSauce("ragu");
    }

    public void buildSpice() {
        pasta.setSpice("rosemary");
    }
}

class PuttanescaPastaBuilder extends PastaBuilder {
    public void buildPastatype() {
        pasta.setPastatype("spaghetti");
    }

    public void buildSauce() {
        pasta.setSauce("olive");
    }

    public void buildSpice() {
        pasta.setSpice("oregano");
    }
}

class Cook {
    private PastaBuilder pastaBuilder;

    public void setPastaBuilder(PastaBuilder pb) {
        pastaBuilder = pb;
    }

    public Pasta getPasta() {
        return pastaBuilder.getPasta();
    }

    public void constructPasta() {
        pastaBuilder.createNewPastaProduct();
        pastaBuilder.buildPastatype();
        pastaBuilder.buildSauce();
        pastaBuilder.buildSpice();
    }
}

public class Builderexample {
    public static void main(String[] args) {
        Cook cook = new Cook();
        PastaBuilder bolognesePastaBuilder = new BolognesePastaBuilder();
        PastaBuilder puttanescaPastaBuilder = new PuttanescaPastaBuilder();

        cook.setPastaBuilder(bolognesePastaBuilder);
        cook.constructPasta();

        Pasta pasta = cook.getPasta();
        System.out.println(pasta.pastatype);
        System.out.println(pasta.sauce);
        System.out.println(pasta.spice);
    }
}