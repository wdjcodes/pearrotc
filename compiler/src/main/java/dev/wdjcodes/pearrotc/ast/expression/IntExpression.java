package dev.wdjcodes.pearrotc.ast.expression;

import dev.wdjcodes.pearrot.PearrotParser;

public class IntExpression extends PearrotExpression{

    Integer mValue;

    public IntExpression(PearrotParser.IntExpressionContext context){
        mValue = Integer.parseInt(context.INTLIT().toString());
    }

    @Override
    public void print() {
        mLogger.debug("INT: " + mValue);
    }

    @Override
    public String codeGen() {
        return mValue.toString();
    }
}
