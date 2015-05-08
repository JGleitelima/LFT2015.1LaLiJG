package mongo.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.List;

import mongo.sablecc.lexer.LexerException;
import mongo.sablecc.node.EOF;
import mongo.sablecc.node.TCommentblockerror;
import mongo.sablecc.node.TEspacobranco;
import mongo.sablecc.node.Token;

public class Main {
	private List<Token> tokens;
    private String programaFonte = null;
    
    
    
    public void obterTokens(MongoCustomLexer lexer) throws LexerException, IOException{
    	Token token;
        do {
            token = lexer.next();
            tokens.add(token);
        } while (!(token instanceof EOF));
    }
    
    public void compilar(String caminhoArquivo){

    	tokens = new ArrayList<Token>();
    	lerArquivoFonte(caminhoArquivo);
 
    	try {
	    	MongoCustomLexer lexer = new MongoCustomLexer(carregarFonte(programaFonte));
	    	obterTokens(lexer);
	        System.out.println("Lexer: Ok");
	        salvarTokensArquivo("test/out3.txt");
    	}catch (IOException e){
    		System.out.println(e.getMessage());
    	}catch (mongo.sablecc.lexer.LexerException e)
    	{
   		System.out.println(e.getMessage());
    	}}
    
	public List<Token> getTokens() {
		return tokens;
	}
	
	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	public void lerArquivoFonte(String caminhoArquivo) {
		try {
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new FileReader(caminhoArquivo));
            String linha = buffer.readLine();
            StringBuilder conteudoArquivo = new StringBuilder();
            while (true) {            	
            	if (linha != null) {
                    conteudoArquivo.append(linha);
                    conteudoArquivo.append("\n");
                } else {
                    break;
                }
                linha = buffer.readLine();
			}
            programaFonte = conteudoArquivo.toString();
            
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo de entrada nao encontrado!\n");
			System.exit(-1);
		} catch (IOException e){
			System.err.println("Erro ao ler arquivo: " + caminhoArquivo + "\n");
			System.exit(-1);
		}
	}
	
	private static PushbackReader carregarFonte(String programaFonte) {
		byte[] bytes = programaFonte.getBytes();
        return new PushbackReader(new InputStreamReader(new ByteArrayInputStream(bytes)),bytes.length);
    }
	
	public String imprimirTokens(){
		StringBuilder listaTokens = new StringBuilder();
		
		for (Token token : getTokens()){
			if (token instanceof TEspacobranco
					|| token instanceof EOF) {
				listaTokens.append(token.getText());
			} else if (token instanceof TCommentblockerror) {
				listaTokens.append("[" + token.getLine() + ","
						+ token.getPos()
						+ "] Error block comment"
						);
			} else {
				listaTokens.append(token.getClass()
						.getSimpleName());
			}
		}
		
		return listaTokens.toString();
	}
	
	public void salvarTokensArquivo(String arquivo){
		System.out.println("Imprimir");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					arquivo));
			writer.write(imprimirTokens());
			writer.flush();
			writer.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Falha ao escrever arquivo!");
			System.exit(-1);
		}
		
	}
}
