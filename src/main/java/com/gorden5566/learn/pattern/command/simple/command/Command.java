package com.gorden5566.learn.pattern.command.simple.command;

import com.gorden5566.learn.pattern.command.simple.group.CodeGroup;
import com.gorden5566.learn.pattern.command.simple.group.PageGroup;
import com.gorden5566.learn.pattern.command.simple.group.RequirementGroup;

public abstract class Command {
    //需求组
    protected RequirementGroup rg = new RequirementGroup();
    //美工组
    protected PageGroup pg = new PageGroup();
    //代码组
    protected CodeGroup cg = new CodeGroup();
    //只有一个方法， 你要我做什么事情
    public abstract void execute();
}
