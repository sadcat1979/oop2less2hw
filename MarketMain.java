
public class MarketMain {

    public static void main(String[] args) {

        Human valeraHuman = new Human("Валера");
        Human egorHuman = new Human("Егор");
        Human viktorHuman = new Human("Виктор");
        Human lenaHuman = new Human("Лена");
        Human mashaHuman = new Human("Маша");
        Human nikitaHuman = new Human("Никита");
        Market market = new Market();
        market.acceptToMarket(valeraHuman);
        market.acceptToMarket(egorHuman);
        market.acceptToMarket(viktorHuman);
        market.update();
        market.acceptToMarket(lenaHuman);
        market.acceptToMarket(mashaHuman);
        market.update();
        market.acceptToMarket(nikitaHuman);
        market.update();
        market.update();
    }
}
