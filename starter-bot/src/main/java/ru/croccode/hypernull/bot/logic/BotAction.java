package ru.croccode.hypernull.bot.logic;

import ru.croccode.hypernull.geometry.Point;
import ru.croccode.hypernull.message.Update;

import java.sql.SQLOutput;
import java.util.*;

public class BotAction {

    private int width;
    private int height;
    private int raduis;
    private int startPoint;
    private int coinPoint;
    private int bot_x;
    private int bot_y;
    private List<Integer> way_x = new ArrayList<>();
    private List<Integer> way_y = new ArrayList<>();

    public List<Integer> getWay_y() {
        return way_y;
    }

    public int getBot_x() {
        return bot_x;
    }

    public int getBot_y() {
        return bot_y;
    }

    public List<Integer> getWay_x() {
        return way_x;
    }

    public int getCoinPoint() {
        return coinPoint;
    }

    public void setCoinPoint(int coinPoint) {
        this.coinPoint = coinPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getBotID() {
        return botID;
    }

    public void setBotID(int botID) {
        this.botID = botID;
    }

    private int botID;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRaduis() {
        return raduis;
    }

    public void setRaduis(int raduis) {
        this.raduis = raduis;
    }

    // Создаем карту вокруг бота
    public void createMap(Update update) {


        // Достаем координаты нашего бота
        Map<Integer, Point> botCord = new HashMap<>();
        botCord.put(botID, update.getBots().get(botID));

        int dx_edge1 = botCord.get(botID).x()-getRaduis();
        int dx_edge2 = botCord.get(botID).x()+getRaduis();
        int dy_edge1 = botCord.get(botID).y()-getRaduis();
        int dy_edge2 = botCord.get(botID).y()+getRaduis();

        // Обработка пограничных значений
        if (dx_edge1 < 0) dx_edge1 = 0;
        if (dx_edge2 > width) dx_edge2 = width;
        if (dy_edge1 < 0) dy_edge1 = 0;
        if (dy_edge2 > height) dy_edge2 = height;

        // Создаем вершины по координатам
        for (int i = dx_edge2; i>dx_edge1; i--) {
            for (int j = dy_edge1; j < dy_edge2; j++) {
            }
        }

        // Узнаем номер вершины в которой находится бот

        int diff = dx_edge2-dx_edge1;
        // Создаем граф

    }

    public void CheckWay(Update update) {
        Map<Integer, Point> botCord = new HashMap<>();
        botCord.put(botID, update.getBots().get(botID));

        List<Point> coins = new ArrayList<>();
        // Проверка по x

        if (update.getCoins() != null) {
            for (Point coin : update.getCoins()) coins.add(coin);
            for (int i = 0; i < coins.size(); i++) {
                if (coins.get(i).y() == botCord.get(botID).y()) {
                    System.out.println(update.getRound());
                    ChechWayOnX(update, coins.get(i), botCord.get(botID));
                    return;
                }
            }
        }
        // Проверка по y

        if (update.getCoins() != null) {
            for (Point coin : update.getCoins()) coins.add(coin);
            for (int i = 0; i < coins.size(); i++) {
                if (coins.get(i).x() == botCord.get(botID).x()) {
                    System.out.println(update.getRound());
                    ChechWayOnY(update, coins.get(i), botCord.get(botID));
                    return;
                }
            }
        }
    }

    private void ChechWayOnY(Update update, Point coin, Point bot) {
        int y1;
        int y2;
        int x = coin.x();
        int way;
        if (bot.y() < coin.y()) {
            y1 = bot.y();
            y2 = coin.y();
            way = 1;
        } else {
            y1 = coin.y();
            y2 = bot.y();
            way = -1;
        }
        for (int i = y1; i < y2; i++) {
            if (update.getBlocks().contains(new Point(x,i))) return;
        }

        for (int i = y1; i < y2; i++) {
            way_y.add(way);
        }

        bot_y = bot.y();
        bot_x = bot.x();
    }

    private void ChechWayOnX(Update update, Point coin, Point bot) {
        int x1;
        int x2;
        int y = coin.y();
        int way;
        if (bot.x() < coin.x()) {
            x1 = bot.x();
            x2 = coin.x();
            way = 1;
        } else {
            x1 = coin.x();
            x2 = bot.x();
            way = -1;
        }
        for (int i = x1; i < x2; i++) {
            if (update.getBlocks().contains(new Point(i,y))) return;
        }

        for (int i = x1; i < x2; i++) {
            way_x.add(way);
        }

        bot_y = bot.y();
        bot_x = bot.x();
    }

}
