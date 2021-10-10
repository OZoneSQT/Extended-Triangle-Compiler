/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Clase Writer para la correcta generacion del AST correspondiente
a los programas compilados por Triangulo Extendido

Ultima fecha de modificación:

30/09/2021

 */

package Triangle.TreeWriterXML;

import Triangle.AbstractSyntaxTrees.Program;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    // Draw the AST representing a complete program.
    public void write(Program ast) {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            //HTML header
            fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

            WriterVisitor layout = new WriterVisitor(fileWriter);
            ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }

}
