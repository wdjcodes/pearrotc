package dev.wdjcodes.pearrotc.ast;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Node {
    protected static final Logger mLogger = LogManager.getLogger();
    public String toString(){
        return this.getClass().getSimpleName();
    }

    public abstract void print();
    public abstract String codeGen();
}
