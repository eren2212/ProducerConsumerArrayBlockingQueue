
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProducerConsumer {
    Random random = new Random();
    //burada kuyruğu 10 ile sınırklıyoruz.
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    public void produce(){
        
        while (true) {            
            
            int value = random.nextInt(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                //bunun ile kuyruğa eleman ekliyoruz
                
                queue.put(value);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Produce Üretiyor:"+value);
            }
        
    }
    
    public void consume(){
        
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                //bunun ile eleman alıyoruz kuyruktan
                int value2 = queue.take();
                System.out.println("Consumer Tüketiyor:"+value2);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Queue size:"+queue.size());
        }
    }
    
    
}
