package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de LocalDeclaration

Ultima fecha de modificación:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class LocalDeclaration extends Declaration {
    public LocalDeclaration(Declaration d1AST, Declaration d2AST, SourcePosition thePosition) {
        super (thePosition);
        D1 = d1AST;
        D2 = d2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitLocalDeclaration(this, o); }

    public Declaration D1;
    public Declaration D2;
}
