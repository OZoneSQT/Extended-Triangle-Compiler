package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de CondRestOfIf

Ultima fecha de modificación:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class CondRestOfIf extends Command {
    public CondRestOfIf(Expression eAST, Command cAST, Command roifAST, SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = cAST;
        CIF = roifAST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitCondRestOfIf(this, o); }

    public Expression E;
    public Command C;
    public Command CIF;
}
