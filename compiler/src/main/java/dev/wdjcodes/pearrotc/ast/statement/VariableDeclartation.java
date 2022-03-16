package dev.wdjcodes.pearrotc.ast.statement;

import dev.wdjcodes.pearrotc.ast.type.PearrotType;

public class VariableDeclartation extends PearrotStatement {
    private String mName;
    private PearrotType mType;

    @Override
    public void print() {
        //TODO Implement
    }

    @Override
    public String codeGen() {
        return null;
    }
}
