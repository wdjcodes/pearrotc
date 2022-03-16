package dev.wdjcodes.pearrotc.ast.statement;

import dev.wdjcodes.pearrot.PearrotParser;
import dev.wdjcodes.pearrotc.ast.Node;
import dev.wdjcodes.pearrotc.ast.expression.PearrotExpression;

public class ReturnStatement extends PearrotStatement{

    PearrotExpression mExpression;

    public ReturnStatement(PearrotParser.ReturnStatementContext context){
        mExpression = PearrotExpression.fromContext(context.pearrotExpression());
    }

    @Override
    public void print() {
        Node.mLogger.debug("RETURN: ");
        mExpression.print();
    }

    @Override
    public String codeGen() {
        return "mov rax, " + mExpression.codeGen() + "\n" + "ret\n";
    }
}
