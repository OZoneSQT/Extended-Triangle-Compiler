package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RangeVarDeclaration

Ultima fecha de modificación:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class RangeVarDeclaration extends Declaration {
    public RangeVarDeclaration(Identifier iAST_for, Expression e1AST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST_for;
        E = e1AST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRangeVarDeclaration(this, o); }

    public Identifier I;
    public Expression E;
}
