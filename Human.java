
public class Human extends Actor {

    public Human(String name) {
        super(name);
    }

    @Override
    public boolean isMakeOrder() {

        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public void setMakeOrder(boolean flag) {
        isMakeOrder = flag;
    }

    @Override
    public void setTakeOrder(boolean flag) {
        isTakeOrder = flag;
    }

    @Override
    String getName() {
        return name;
    }
}
