import java.time.LocalDateTime;

public class Auction extends  Thread{
    Double curPrice = -1.0;
    String winner = "";
    LocalDateTime endOfAuctionTime;

    public Auction(LocalDateTime endOfAuctionTime) {
        this.endOfAuctionTime = endOfAuctionTime;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(endOfAuctionTime)) {

        }
        this.interrupt();

        if(winner != "") {
            System.out.println("Аукцион выиграл: " +winner + ", его ставка :" + curPrice);
        }
        else {
            System.out.println("Победителя нет! Назначаются повторные торги...");
        }
    }

    public synchronized void setValues(double price, String name) throws InterruptedException {
        {
            if (price > curPrice || !this.isAlive()) {
                curPrice = price;
                winner = name;
                System.out.println("Участник: "+ name + ", его ставка: " + price);
            }
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public synchronized Double getCurPrice() {
        return curPrice;
    }
}
