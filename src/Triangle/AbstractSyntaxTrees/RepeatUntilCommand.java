package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RepeatUntilCommand

Ultima fecha de modificación:

28/09/2021

 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatUntilCommand extends Command {
    public RepeatUntilCommand(Expression eAST_until, Command cAST_until, SourcePosition thePosition) {
        super(thePosition);
        E = eAST_until;
        C = cAST_until;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatUntilCommand(this, o); }

    public Expression E;
    public Command C;
}
