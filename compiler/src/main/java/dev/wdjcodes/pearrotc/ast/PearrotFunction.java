package dev.wdjcodes.pearrotc.ast;

import dev.wdjcodes.pearrot.PearrotParser;
import dev.wdjcodes.pearrotc.ast.statement.PearrotStatement;

import java.util.ArrayList;
import java.util.List;

public class PearrotFunction extends Node{
    private String mName;
    private List<PearrotStatement> mPearrotStatements = new ArrayList<>();

    PearrotFunction(PearrotParser.PearrotFunctionContext context){
        mName = context.ID().toString();
        for(PearrotParser.StatementContext sContext : context.statements){
            mPearrotStatements.add(PearrotStatement.fromContext(sContext));
        }
    }

    @Override
    public void print() {
        mLogger.debug("FUN: " + mName);
        for(PearrotStatement statement : mPearrotStatements){
            statement.print();
        }
    }

    @Override
    public String codeGen() {
        StringBuilder sb = new StringBuilder();
        sb.append(mName + ":\n");
        for(PearrotStatement s : mPearrotStatements){
            sb.append(s.codeGen());
        }
        return sb.toString();
    }
}
