package org.example.felipe;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

public class GramCompilador {

    private String compilar;

    public GramCompilador(String compilar) {
        this.compilar = compilar;
    }

    public void compile() {
        CharStream input = CharStreams.fromString(this.compilar);
        GramLexer lexer = new GramLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> tokenList = tokens.getTokens();
        for (Token token : tokenList) {
            int tokenType = token.getType();
            String tokenName = lexer.getVocabulary().getSymbolicName(tokenType);
            String tokenText = token.getText();
            int line = token.getLine();
            int column = token.getCharPositionInLine();
            System.out.println("Token-> " + tokenName + " | Texto -> " + tokenText + " | Linha-> " + line + " | Coluna-> " + column);
        }
        GramParser parser = new GramParser(tokens);
        ParseTree tree = parser.program();
    }
}
