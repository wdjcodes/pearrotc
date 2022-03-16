package dev.wdjcodes.pearrotc;

import dev.wdjcodes.pearrot.PearrotLexer;
import dev.wdjcodes.pearrot.PearrotParser;
import dev.wdjcodes.pearrotc.ast.PearrotFile;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PearrotCompiler {

    public static void main(String[] args){
            if(args.length < 1){
                System.out.println("No target\n");
                return;
            }
        try {
            PearrotLexer lexer = new PearrotLexer(CharStreams.fromFileName(args[0]));
            PearrotParser parser = new PearrotParser(new CommonTokenStream(lexer));
            PearrotFile pFile = new PearrotFile(parser.pearrotFile());
            pFile.print();
            FileWriter fw = new FileWriter("out.asm");
            fw.write(pFile.codeGen());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
