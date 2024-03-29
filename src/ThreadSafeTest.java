public class ThreadSafeTest implements Runnable {
    int num = 10;
    @Override
    public void run() {
        while (true){
            synchronized (""){
                if (num>0){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("tickets" + --num);
                }
                else {
                    return;
                }
            }
        }
    }
    public static void main(String[] args){
        ThreadSafeTest t = new ThreadSafeTest();
        Thread tA = new Thread(t);
        Thread tB = new Thread(t);
        Thread tC = new Thread(t);
        Thread tD = new Thread(t);
        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}
