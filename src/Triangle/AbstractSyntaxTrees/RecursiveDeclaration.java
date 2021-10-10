package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RecursiveDeclaration

Ultima fecha de modificación:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecursiveDeclaration extends Declaration {
    public RecursiveDeclaration(Declaration pfAST, SourcePosition thePosition) {
        super(thePosition);
        PF = pfAST;

    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRecursiveDeclaration(this, o); }

    public Declaration PF;
}
