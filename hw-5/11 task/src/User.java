import java.time.LocalDateTime;

public class User extends  Thread{
    String name;
    double bet;
    Auction auction;

    static final int STEP = 10;

    public User(String name, Auction a) {
        this.name = name;
        this.auction = a;
        bet = auction.curPrice;
    }

    @Override
    public void run() {
        while (!auction.isInterrupted()) {
            try {
                {
                    if (LocalDateTime.now().isBefore(auction.getEndOfAuction()) && bet < auction.getCurPrice()) {
                        auction.setValues(auction.getCurPrice() + STEP, name);
                        bet += STEP;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
