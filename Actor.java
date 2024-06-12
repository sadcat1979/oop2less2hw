
public abstract class Actor implements ActorBehaviour {

    protected String name;
    protected boolean isMakeOrder;//непонятно, зачем оно надо, но пусть означает как в презентации: состояние готовности сделать заказ
    protected boolean isTakeOrder;

    public Actor(String name) {
        this.name = name;
        isTakeOrder = false;
        isMakeOrder = false;

    }

    abstract String getName();
}
