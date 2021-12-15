package ru.croccode.hypernull.bot;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.CollationElementIterator;
import java.util.*;

import ru.croccode.hypernull.bot.logic.BotAction;
import ru.croccode.hypernull.domain.MatchMode;
import ru.croccode.hypernull.geometry.Offset;
import ru.croccode.hypernull.geometry.Point;
import ru.croccode.hypernull.io.SocketSession;
import ru.croccode.hypernull.message.Hello;
import ru.croccode.hypernull.message.MatchOver;
import ru.croccode.hypernull.message.MatchStarted;
import ru.croccode.hypernull.message.Move;
import ru.croccode.hypernull.message.Register;
import ru.croccode.hypernull.message.Update;

public class StarterBot implements Bot {

	private static final Random rnd = new Random(System.currentTimeMillis());

	private final MatchMode mode;

	private Offset moveOffset;

	private int moveCounter = 0;

	public StarterBot(MatchMode mode) {
		this.mode = mode;
	}

	public BotAction botAction = new BotAction();

	public int[] parents;

	public List<Point> points;

	public boolean state;

	public List<Integer> way = new ArrayList<>();

	@Override
	public Register onHello(Hello hello) {
		Register register = new Register();
		register.setMode(mode);
		register.setBotName("VikaBot");
		return register;
	}

	@Override
	public void onMatchStarted(MatchStarted matchStarted) {
		botAction.setBotID(matchStarted.getYourId());
		botAction.setWidth(matchStarted.getMapSize().width());
		botAction.setHeight(matchStarted.getMapSize().height());
		botAction.setRaduis(matchStarted.getViewRadius());
	}

	@Override
	public Move onUpdate(Update update) {
		if (botAction.getWay_x().isEmpty() && botAction.getWay_y().isEmpty()) botAction.CheckWay(update);
		if (!botAction.getWay_x().isEmpty()) {
			moveOffset = new Offset(botAction.getWay_x().get(0),0);
			botAction.getWay_x().remove(0);
		}
		else if (!botAction.getWay_y().isEmpty()) {
			moveOffset = new Offset(0,botAction.getWay_y().get(0));
			botAction.getWay_y().remove(0);
		}
		else {
			if (moveOffset == null || moveCounter > 5 + rnd.nextInt(5)) {
				moveOffset = new Offset(
						rnd.nextInt(3) - 1,
						rnd.nextInt(3) - 1
				);
				moveCounter = 0;
			}
			moveCounter++;
			}

		Move move = new Move();
		move.setOffset(moveOffset);
		return move;
	}


	@Override
	public void onMatchOver(MatchOver matchOver) {
	}

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket();
		socket.setTcpNoDelay(true);
		socket.setSoTimeout(300_000);
		socket.connect(new InetSocketAddress("localhost", 2021));

		SocketSession session = new SocketSession(socket);
		StarterBot bot = new StarterBot(MatchMode.FRIENDLY);
		new BotMatchRunner(bot, session).run();
	}
}
