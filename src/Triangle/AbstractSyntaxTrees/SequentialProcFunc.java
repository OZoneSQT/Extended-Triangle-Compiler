package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de SequentialProcFunc

Ultima fecha de modificación:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialProcFunc extends ProcFuncDeclaration {
    public SequentialProcFunc(ProcFuncDeclaration pfd1AST, ProcFuncDeclaration pfd2AST, SourcePosition thePosition) {
        super(thePosition);
        PFD1 = pfd1AST;
        PFD2 = pfd2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitSequentialProcFunc(this, o); }

    public ProcFuncDeclaration PFD1;
    public ProcFuncDeclaration PFD2;

}
