import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        Main obj = new Main();
        obj.printBTCPrice();
    }

    public void printBTCPrice() throws IOException {
        Runnable bitcoinPriceRunnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date();
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://cryptowat.ch/").get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                Elements bitcoinPrice = doc.select("a[href=/assets/btc/usd/chart] > div > span._3XNm6CSrchU-MNbu1Zh3m2");
                System.out.println("BTC Price @ " + formatter.format(date) + " \n" + bitcoinPrice.text() + "\n");
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(bitcoinPriceRunnable, 0, 10, TimeUnit.SECONDS);
    }
}
