package code;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *CyclicBarrier-Demo
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        for (int i = 0;i<3;i++){
            new Thread(new MyRunnable(barrier), "队友"+i).start();
        }
        System.out.println("主方法已经结束");
    }
    private static class MyRunnable implements Runnable{
        private CyclicBarrier cyclicBarrier;

        public MyRunnable(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {

            for (int i = 1;i<4;i++){
                Random random = new Random();
                int randomNum = random.nextInt((3000 - 1000) + 1) + 1000;
                try {
                    Thread.sleep(randomNum);
                    System.out.println(Thread.currentThread().getName() + ", 通过了第"+i+"个障碍物, 使用了 "+((double)randomNum/1000)+"s");
                    //this.cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
