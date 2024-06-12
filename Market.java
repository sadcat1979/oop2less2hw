
import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {

    List<Actor> actorList = new ArrayList<>();
    private final int takeThroughPut = 2; //Отсебятина из-за мутного ТЗ: у скольких в очереди можем СРАЗУ ВЗЯТЬ заказ

    private void printQueue() {//для наглядности
        if (!actorList.isEmpty()) {
            String names = "В очереди стоят:";
            for (Actor actor : actorList) {
                names += " " + actor.getName();
                if (actor.isTakeOrder) names+="(ждёт выдачи)";
                if (actor.isMakeOrder) names+="(готов заказать)";
            }
            System.out.println(names);
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        if (!actorList.contains(actor)) {
            System.out.println(actor.getName() + " заходит в магазин");
            takeInQueue(actor); //зашёл и сразу в очередь
        } else {
            System.out.println(actor.getName() + " уже в магазине");
        }
    }

    @Override
    public void takeInQueue(Actor actor) {
        //System.out.println(actor.getName() + " встаёт в очередь");
        actor.setMakeOrder(true); //ведь у любого в очереди есть "Готовность сделать заказ"
        actorList.add(actor); //получается очередь готовых сделать заказ, иначе что они там делают
        printQueue();
    }

    @Override
    public void takeOrders() {
        //Берём заказ у takeThroughPut людей
        for (int i = 0; i < actorList.size() && i < takeThroughPut; i++) {
            actorList.get(i).isMakeOrder = false;//"Готовность сделать заказ" исчезла
            actorList.get(i).isTakeOrder = true;//Ожидание приготовления появилось
            //Но поскольку очередь одна, выкинуть из очереди человека мы не можем
            System.out.println(actorList.get(i).getName() + " отстоял очередь и сделал заказ");
        }
    }

    @Override
    public void giveOrders() {
        for (int i = 0; i < actorList.size(); i++) {
            if (actorList.get(i).isTakeOrder) {
                System.out.println(actorList.get(i).getName() + " получил заказ");
            }
        }
        releaseFromQueue();//сразу чистим очередь
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseFromQueue = new ArrayList<>();
        for (Actor actor : actorList) {
            if (actor.isTakeOrder) {
//                System.out.println(actor.getName() + " выходит  из очереди");
                releaseFromQueue.add(actor);
            }
        }
        releaseFromMarket(releaseFromQueue);
//        printQueue();
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " выходит из магазина");
            actorList.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        printQueue();
        giveOrders();
    }
}
