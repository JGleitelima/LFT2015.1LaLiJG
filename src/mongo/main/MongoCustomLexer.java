package mongo.main;

import java.io.IOException;
import java.io.PushbackReader;

import mongo.sablecc.lexer.Lexer;
import mongo.sablecc.lexer.LexerException;
import mongo.sablecc.node.EOF;
import mongo.sablecc.node.InvalidToken;
import mongo.sablecc.node.TCommentblock;
import mongo.sablecc.node.TCommentblockend;
import mongo.sablecc.node.TCommentblockerror;

public class MongoCustomLexer extends Lexer{
	
	private int contador;
	private TCommentblock comentario;
	private StringBuffer texto;
	
	public MongoCustomLexer(PushbackReader in) {
		super(in);
		comentario = null;
        contador = 0;
        texto = null;
	}
	
protected void filter() throws LexerException, IOException {
		if (state.equals(State.COMENTARIO)) {
			if (comentario == null) {
				comentario = (TCommentblock) token;
				texto = new StringBuffer(comentario.getText());
				contador = 1;
				token = null;
			} else {
				texto.append(token.getText());
				if (token instanceof TCommentblock) {
					contador++;
				}else if (token instanceof TCommentblockend) {
					contador--;
				}else if (token instanceof EOF){
                    throw new LexerException(new InvalidToken(texto.toString(), token.getLine(), token.getPos()), "[" + (token.getLine()) + "," + (token.getPos()) + "] Error block comment");
				}
				
				if (contador != 0) {
					token = null;
				} else {
					
					token = comentario;
					state = State.NORMAL;
					comentario = null;
				}
			}
		}else {
			if (token instanceof TCommentblockerror){
				//encontro um fim de comentario sem inicio
				TCommentblockerror t = new TCommentblockerror();
				t.setLine(token.getLine());
				t.setPos(token.getPos());
				token = t;
				comentario = null;
				throw new LexerException(new InvalidToken(texto.toString(), token.getLine(), token.getPos()), "[" + (token.getLine()) + "," + (token.getPos()) + "] Error block comment");
			}
			
		}
	}
	
}
