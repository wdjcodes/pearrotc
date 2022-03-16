package dev.wdjcodes.pearrotc.ast;

import dev.wdjcodes.pearrot.PearrotParser;

public class PearrotClass extends Node{
    private String mName;
    private PearrotFunction mPearrotFunction;

    PearrotClass(PearrotParser.PearrotClassContext context){
        mName = context.ID().toString();
        mPearrotFunction = new PearrotFunction(context.pearrotFunction());
    }

    @Override
    public void print() {
        mLogger.debug("CLASS: " + mName);
        mPearrotFunction.print();
    }

    @Override
    public String codeGen() {
        return mPearrotFunction.codeGen();
    }
}
