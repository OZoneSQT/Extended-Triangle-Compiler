package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RepeatForInCommand

Ultima fecha de modificación:

28/09/2021

 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatForInCommand extends Command {
    public RepeatForInCommand(Declaration invdAST, Command cAST_for_in, SourcePosition thePosition) {
        super(thePosition);

        IVD = invdAST;
        C = cAST_for_in;
    }


    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForInCommand(this, o);
    }

    public Declaration IVD;
    public Command C;
}
