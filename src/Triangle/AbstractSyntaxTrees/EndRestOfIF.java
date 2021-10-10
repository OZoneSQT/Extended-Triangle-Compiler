package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripci�n:

Nueva estructura de datos para el AST de EndRestOfIf

Ultima fecha de modificaci�n:

28/09/2021

 */


import Triangle.SyntacticAnalyzer.SourcePosition;

public class EndRestOfIF extends Command {
    public EndRestOfIF(Command cAST, SourcePosition thePosition) {
        super(thePosition);

        C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitEndRestOfIf(this, o); }

    public Command C;
}
