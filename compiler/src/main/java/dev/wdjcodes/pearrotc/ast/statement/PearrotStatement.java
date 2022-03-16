package dev.wdjcodes.pearrotc.ast.statement;

import dev.wdjcodes.pearrot.PearrotParser;
import dev.wdjcodes.pearrotc.ast.Node;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class PearrotStatement extends Node {

    public static PearrotStatement fromContext(PearrotParser.StatementContext context) throws IllegalArgumentException{
        ParseTree child = context.getChild(0);
        if(child instanceof PearrotParser.ReturnStatementContext){
            return new ReturnStatement((PearrotParser.ReturnStatementContext)child);
        }
        throw new IllegalArgumentException("Unsupported Statement type:" + child.getClass().getSimpleName());
    }

}
