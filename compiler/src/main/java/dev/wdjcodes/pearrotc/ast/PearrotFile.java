package dev.wdjcodes.pearrotc.ast;

import dev.wdjcodes.pearrot.PearrotParser;

public class PearrotFile extends  Node {

    private PearrotClass mPearrotClass;

    public PearrotFile(PearrotParser.PearrotFileContext context){
        mPearrotClass = new PearrotClass(context.pearrotClass());
    }

    @Override
    public void print() {
        mLogger.debug(toString());
        mPearrotClass.print();
    }

    @Override
    public String codeGen() {
        return "section .data\n" +
                "global start\n" +
                "section .text\n" +
                mPearrotClass.codeGen() +
                statFun();
    }

    private String statFun(){
        return "start:\n" +
                "call main\n" +
                "mov rbx, rax\n" +
                "mov rax, 0x1\n" +
                "int 0x80\n";// +
    }
}
