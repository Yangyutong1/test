package controller.lockController;


import java.util.concurrent.TimeUnit;

/**
 * 关于锁对象
 * 类锁/对象锁
 */
class Phone {

    public synchronized void sendEmil() {
        try {TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}
        System.out.println("---sendEmil---");
    }

    public synchronized void sendSMS() {
        System.out.println("---sendSMS---");
    }

    public void hello(){
        System.out.println("hello");
    }
}

/**
 *
 * /**
 *  * 现象描述：
 *  * 1 标准访问ab两个线程，请问先打印邮件还是短信？ --------先邮件，后短信  共用一个对象锁
 *  * 2. sendEmail钟加入暂停3秒钟，请问先打印邮件还是短信？---------先邮件，后短信  共用一个对象锁
 *  * 3. 添加一个普通的hello方法，请问先打印普通方法还是邮件？ --------先hello，再邮件
 *  * 4. 有两部手机，请问先打印邮件还是短信？ ----先短信后邮件  资源没有争抢，不是同一个对象锁
 *  * 5. 有两个静态同步方法，一步手机， 请问先打印邮件还是短信？---------先邮件后短信  共用一个类锁
 *  * 6. 有两个静态同步方法，两部手机， 请问先打印邮件还是短信？ ----------先邮件后短信 共用一个类锁
 *  * 7. 有一个静态同步方法 一个普通同步方法，请问先打印邮件还是短信？ ---------先短信后邮件   一个用类锁一个用对象锁
 *  * 8. 有一个静态同步方法，一个普通同步方法，两部手机，请问先打印邮件还是短信？ -------先短信后邮件 一个类锁一个对象锁
 *  结论
 *  关于对象锁
 * 一个对象如果有多个synchronized方法，但是只要有一个线程去调用其中synchronized方法
 * 其他线程就会造成等待，阻塞，所以在某一时间，只能有一个线程访问synchronized
 * 锁的是当前对象的this
 *  结论
 * ● 对于普通同步方法，锁的是当前实例对象，通常指this，所有的同步方法用的都是同一把锁--->phone1实例对象本身 public synchronized void sendEmil()
 * ● 对于静态同步方法，锁的时当前类的Class对象，锁的是Phone这个Class对象， public static synchronized void sendEmil()
 * ● 对于同步方法块，锁的时synchronized括号内的对象
 */
public class lockDemo {
    public static void main(String[] args) {

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone1.sendEmil();
        }, "A").start();

        try {TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}

        new Thread(() -> {
            phone2.sendSMS();
        }, "B").start();
    }
}
