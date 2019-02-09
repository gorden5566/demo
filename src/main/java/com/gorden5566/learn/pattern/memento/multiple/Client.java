package com.gorden5566.learn.pattern.memento.multiple;

public class Client {
    public static void main(String[] args) {
        //定义出发起人
        Originator ori = new Originator();

        //初始化
        ori.setState1("中国");
        ori.setState2("强盛");
        ori.setState3("繁荣");
        System.out.println("===初始化状态===\n" + ori);

        //定义出备忘录管理员
        Caretaker caretaker = new Caretaker();

        //创建一个备忘录
        caretaker.setMemento(ori.createMemento());

        //修改状态值
        ori.setState1("软件");
        ori.setState2("架构");
        ori.setState3("优秀");

        System.out.println("\n===修改后状态===\n" + ori);
        //恢复一个备忘录
        ori.restoreMemento(caretaker.getMemento());
        System.out.println("\n===恢复后状态===\n" + ori);
    }
}
