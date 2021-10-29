/*
 * IDE-Triangle v1.0
 * Compiler.java 
 */

package Triangle;

import Triangle.CodeGenerator.Frame;
import java.awt.event.ActionListener;
import Triangle.SyntacticAnalyzer.SourceFile;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Parser;
import Triangle.ContextualAnalyzer.Checker;
import Triangle.CodeGenerator.Encoder;
import Triangle.TreeWriterXML.Writer;
import Triangle.SyntacticAnalyzer.HTMLWriter;



/** 
 * This is merely a reimplementation of the Triangle.Compiler class. We need
 * to get to the ASTs in order to draw them in the IDE without modifying the
 * original Triangle code.
 *
 * @author Luis Leopoldo Pérez <luiperpe@ns.isi.ulatina.ac.cr>
 */

/*
    ITCR- IC-5701 - Proyecto 1
    Modificación realizada
    ¿Qué se agregó?
    * La creación del archivo .html
    * La creación del archivo .xml

    ¿Qué se comentó?
    * las linea: checker.check(rootAST);
    * las linea: encoder.encodeRun(rootAST, false);
    * las linea: encoder.saveObjectProgram(sourceName.replace(".tri", ".tam"));

    Autores:
    Eric Alpizar y Jacob Picado

    Descripción:
    Se agregó la creación de los archivos .html y .xml, creando el objeto y realizando
    el método .write() respectivo para cada objeto.

    Ultima fecha de modificación:
    03/10/2021
 */


public class IDECompiler {

    // <editor-fold defaultstate="collapsed" desc=" Methods ">
    /**
     * Creates a new instance of IDECompiler.
     *
     */
    public IDECompiler() {
    }
    
    /**
     * Particularly the same compileProgram method from the Triangle.Compiler
     * class.
     * @param sourceName Path to the source file.
     * @return True if compilation was succesful.
     */
    public boolean compileProgram(String sourceName) {
        System.out.println("********** " +
                           "Triangle Compiler (IDE-Triangle 1.0)" +
                           " **********");
        
        System.out.println("Syntactic Analysis ...");
        SourceFile source = new SourceFile(sourceName);
        Scanner scanner = new Scanner(source);
        report = new IDEReporter();
        Parser parser = new Parser(scanner, report);
        boolean success = false;
                
        rootAST = parser.parseProgram();

        // Se llama al writer del generador de HTML
        
        SourceFile sourceHTML = new SourceFile(sourceName);
        Scanner scannerHTML = new Scanner(sourceHTML);
        HTMLWriter htmlWriter = new HTMLWriter(sourceName.replace(".tri", ".html"), scannerHTML);
        htmlWriter.write();
        
        if (report.numErrors == 0) {
            System.out.println("Contextual Analysis ...");
            Checker checker = new Checker(report);
            checker.check(rootAST);
            if (report.numErrors == 0) {
                System.out.println("Code Generation ...");
                Encoder encoder = new Encoder(report);
                //encoder.encodeRun(rootAST, false);   DISABLED FOR THE FIRST PROJECT
                
                if (report.numErrors == 0) {

                    //encoder.saveObjectProgram(sourceName.replace(".tri", ".tam"));  DISABLED FOR THE FIRST PROJECT
                    Writer xmlWriter = new Writer(sourceName.replace(".tri", ".xml"));
                    xmlWriter.write(rootAST);
                    success = true;
                }
                
            }
        }

        if (success)
            System.out.println("Compilation was successful.");
        else
            System.out.println("Compilation was unsuccessful.");
        
        return(success);
    }
      
    /**
     * Returns the line number where the first error is.
     * @return Line number.
     */
    public int getErrorPosition() {
        return(report.getFirstErrorPosition());
    }
        
    /**
     * Returns the root Abstract Syntax Tree.
     * @return Program AST (root).
     */
    public Program getAST() {
        return(rootAST);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Attributes ">
    private Program rootAST;        // The Root Abstract Syntax Tree.    
    private IDEReporter report;     // Our ErrorReporter class.
    // </editor-fold>
}
