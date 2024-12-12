package controller.domain;

import java.util.concurrent.Callable;

public class threadDemo2 implements Callable {

    @Override
    public Object call() throws Exception {
        return 200;
    }
}
