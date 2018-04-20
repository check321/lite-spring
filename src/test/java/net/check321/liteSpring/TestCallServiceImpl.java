package net.check321.liteSpring;

public class TestCallServiceImpl implements TestCallService {

    private String msg;

    @Override
    public void call() {
        System.out.println("test call : " + msg);
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
