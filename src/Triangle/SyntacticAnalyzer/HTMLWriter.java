package Triangle.SyntacticAnalyzer;

import java.io.FileWriter;
import java.io.IOException;

/*
    ITCR- IC-5701 - Proyecto 1
    Modificación realizada

    Autores:
    Eric Alpizar y Jacob Picado

    Descripción:
    Se creó la clase HTMLWriter que junto a su método write() son los encargados de crear el archivo .html.

    Ultima fecha de modificación:
    03/10/2021
*/

public class HTMLWriter {

    private String fileName;
    private Scanner lexicalAnalyser;
    private Token currentToken;
    private String textHTML="";

    public HTMLWriter (String fileName, Scanner lexicalAnalyser) {
        this.fileName = fileName;
        this.lexicalAnalyser=lexicalAnalyser;

    }
    public void write(){
        try {
            //HTML header
            textHTML="<p style=\"font-family: 'DejaVu Sans', monospace;\">";

            //scan begins
            currentToken = lexicalAnalyser.scanText();

            while (currentToken.kind != Token.EOT) {
                
                switch (currentToken.kind){
                    case Token.INTLITERAL:
                    case Token.CHARLITERAL:
                        textHTML=textHTML+"<font color='#0000cd'>"+currentToken.spelling+"</font>";
                        break;

                    case -1://if the text is a comment
                        textHTML=textHTML+"<font color='#00b300'>"+currentToken.spelling+"</font>";
                        break;
                    case -2://if the text is a comment with a EOL
                        textHTML=textHTML+"<font color='#00b300'>"+currentToken.spelling+"</font>";
                        textHTML=textHTML+"<br>";
                        break;
                    case -3://if the text is a space
                        textHTML=textHTML+"<font style='padding-left:1em'></font>";
                        break;
                    case -4://if the text is a \n
                        textHTML=textHTML+"<br>";
                        break;
                    case -5://if the text is a \t
                        textHTML=textHTML+"<font style='padding-left:4em'></font>";
                        break;
                    case -6://if the text is a \r
                        break;


                    default://if is a reserved word or the other token
                        if (currentToken.kind>Token.OPERATOR && currentToken.kind<Token.DOT){ //reserved word
                            textHTML=textHTML+"<b>"+currentToken.spelling+"</b>";
                            //System.out.println("IF: "+currentToken.spelling+" Numero: "+currentToken.kind);
                            
                        }else if(currentToken.kind>-1 && currentToken.kind<45) {//the other token
                            textHTML=textHTML+currentToken.spelling;
                            //System.out.println("ELSE: "+currentToken.spelling+" Numero: "+currentToken.kind);
                        }else{//Token.ERROR = Lexical Error
                            return;
                        }
                        break;
                    
                }
                currentToken = lexicalAnalyser.scanText();
            }
            //close the main tag
            textHTML=textHTML+"</p>";

            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(textHTML);
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating html file");
            e.printStackTrace();
        }

    }


}
