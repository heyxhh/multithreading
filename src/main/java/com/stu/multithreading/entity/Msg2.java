package com.stu.multithreading.entity;

public class Msg2 {
    private Long id;

    private String sender;

    private String msg;

    public Msg2() {
    }

    public Msg2(Long id, String sender, String msg) {
        this.id = id;
        this.sender = sender;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
