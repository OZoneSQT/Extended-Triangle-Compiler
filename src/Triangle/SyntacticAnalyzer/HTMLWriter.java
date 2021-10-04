package Triangle.SyntacticAnalyzer;

import java.io.FileWriter;
import java.io.IOException;


public class HTMLWriter {

    private String fileName;
    private Scanner lexicalAnalyser;
    private Token currentToken;

    public HTMLWriter (String fileName, Scanner lexicalAnalyser) {
        this.fileName = fileName;
        this.lexicalAnalyser=lexicalAnalyser;

    }
    public void write(){
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            //HTML header
            fileWriter.write("<p style=\"font-family: 'DejaVu Sans', monospace;\">");

            //scan begins
            currentToken = lexicalAnalyser.scanText();

            while (currentToken.kind != Token.EOT) {
                
                switch (currentToken.kind){
                    case Token.INTLITERAL:
                    case Token.CHARLITERAL:
                        fileWriter.write("<font color='#0000cd'>"+currentToken.spelling+"</font>");
                        break;

                    case -1://if the text is a comment
                        fileWriter.write("<font color='#00b300'>"+currentToken.spelling+"</font>");
                        break;
                    case -2://if the text is a comment with a EOL
                        fileWriter.write("<font color='#00b300'>"+currentToken.spelling+"</font>");
                        fileWriter.write("<br>");
                        break;
                    case -3://if the text is a space
                        fileWriter.write("<font style='padding-left:1em'></font>");
                        break;
                    case -4://if the text is a \n
                        fileWriter.write("<br>");
                        break;
                    case -5://if the text is a \t
                        fileWriter.write("<font style='padding-left:4em'></font>");
                        break;


                    default://if is a reserved word or the other token
                        if (currentToken.kind>Token.OPERATOR && currentToken.kind<Token.DOT){ //reserved word
                            fileWriter.write("<b>"+currentToken.spelling+"</b>");
                            //System.out.println("IF: "+currentToken.spelling+" Numero: "+currentToken.kind);
                            
                        }else{//the other token
                            fileWriter.write(currentToken.spelling);
                            //System.out.println("ELSE: "+currentToken.spelling+" Numero: "+currentToken.kind);
                        }
                        break;
                    
                }
                currentToken = lexicalAnalyser.scanText();
            }
            //close the main tag
            fileWriter.write("</p>"); 

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating html file");
            e.printStackTrace();
        }

    }


}