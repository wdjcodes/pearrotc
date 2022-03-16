package dev.wdjcodes.pearrotc.ast.expression;

import dev.wdjcodes.pearrot.PearrotParser;
import dev.wdjcodes.pearrotc.ast.Node;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class PearrotExpression extends Node {
    public static PearrotExpression fromContext(PearrotParser.PearrotExpressionContext context){
        ParseTree child = context.getChild(0);
        if(child instanceof PearrotParser.IntExpressionContext){
            return new IntExpression((PearrotParser.IntExpressionContext) child);
        }
        return null;
    }
}
