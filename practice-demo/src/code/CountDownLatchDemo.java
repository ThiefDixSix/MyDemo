package code;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch demo
 * 等同于lol读条需要所有玩家达到100%才能进行游戏
 */
public class CountDownLatchDemo{
    public final static int PLAYER_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(PLAYER_COUNT);
        System.out.println("正在等待所有玩家准备好");
        for (int i=0 ;i<PLAYER_COUNT;i++){

            new Thread(new MyThread(latch)).start();
        }
        latch.await();
        System.out.println("开始游戏");
    }

    private static class MyThread implements Runnable{
        private final CountDownLatch latch;
        public MyThread(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run() {
            Random random = new Random();
            int randomNum = random.nextInt((3000-1000)+1)+1000;
            try {
                Thread.sleep(randomNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 已经准备好了, 所使用的时间为"+((double)randomNum/1000)+"s");
            latch.countDown();
        }
    }
}